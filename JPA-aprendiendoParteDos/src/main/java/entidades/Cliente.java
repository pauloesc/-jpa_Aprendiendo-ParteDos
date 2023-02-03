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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//para indicarle que es una entidad y que por lo tanto se debe guardar en la base de datos
@Entity
@Table
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 8094006097229308183L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private int dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	
	//no poner @column (da error)
	@OneToOne(cascade = CascadeType.ALL)
	//crear una columna que contenga la clave foranea de domicilio
	@JoinColumn(name = "fk_domicilio")
	private Domicilio domicilio;
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> cliente = new ArrayList<Factura>();
	
	
	public Cliente() {
	}
	
	public Cliente(int dni, String nombre, String apellido, Domicilio domicilio) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public List<Factura> getCliente() {
		return cliente;
	}

	public void setCliente(List<Factura> cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
