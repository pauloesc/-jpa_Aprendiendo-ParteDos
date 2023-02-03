package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Articulo implements Serializable {

	private static final long serialVersionUID = 6209039853286388617L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private int cantidad;
	@Column
	private String denominacion;
	@Column
	private int precio;
	
	@OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
	private List<DetalleFactura> detalle_f = new ArrayList<DetalleFactura>();
	
	/*
	 * se utiliza PERSIST porque si un articulo trae una categoria inexistente la quiero guardar
	 * se utiliza MERGE para que se actualize una categoria existente  
	 */
	
	/*
	 * joinTable va a crear una tabla con dos atributos.
	 * si la relacion es bidireccional o unidireccional entonces hacer.
	 */ 
	 @JoinTable(
			 name= "articulo_categoria",
			 joinColumns = @JoinColumn(name = "articulo_id"),
			 inverseJoinColumns = @JoinColumn(name = "categoria_id")
			 )
	 
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	public Articulo() {
	}

	public Articulo(int cantidad, String denominacion, int precio) {
		this.cantidad = cantidad;
		this.denominacion = denominacion;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetalle_f() {
		return detalle_f;
	}

	public void setDetalle_f(List<DetalleFactura> detalle_f) {
		this.detalle_f = detalle_f;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
}
