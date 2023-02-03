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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8566810405324605791L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private int numero;
	@Column
	private String total;
	
	/*
	 * utilizamos PERSIST ya que el comportamiento que quiero es:
	 * si el cliente no existe lo crea en la tabla clientes
	 * si borro una factura no se borra el cliente
	 */
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	/*
	 * si borra una factura se borran sus detalles
	 */
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleFactura> detalle_f = new ArrayList<DetalleFactura>();
	
	public Factura() {
	}
	
	public Factura(int numero, String total) {
		this.numero = numero;
		this.total = total;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DetalleFactura> getDetalle_f() {
		return detalle_f;
	}

	public void setDetalle_f(List<DetalleFactura> detalle_f) {
		this.detalle_f = detalle_f;
	}


	
	
}
