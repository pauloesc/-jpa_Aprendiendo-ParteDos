package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Domicilio implements Serializable {

	private static final long serialVersionUID = 5643457279914664945L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombreCalle;
	@Column
	private int numero;
	
	//mappedBy toma el nombre del atributo que esta del otro lado de la relacion
	@OneToOne(mappedBy = "domicilio")
	private Cliente cliente;
	
	public Domicilio() {
	}
	public Domicilio(String nombreCalle, int numero) {
		this.nombreCalle = nombreCalle;
		this.numero = numero;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreCalle() {
		return nombreCalle;
	}
	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	
	
}
