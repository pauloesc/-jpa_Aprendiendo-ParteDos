package programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class pruebaEmpresa8 {

	public void hacerCosas() {

		EntityManagerFactory emf = principal.crearEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		/*
		 * try { em.getTransaction().begin(); Domicilio d = new Domicilio("azul", 4552);
		 * Cliente c = new Cliente(4730, "paul", "sanc", d); em.persist(c);
		 * em.getTransaction().commit(); } catch (Exception e) {
		 * em.getTransaction().rollback(); System.out.println(e); } finally {
		 * em.close(); }
		 */

		em.getTransaction().begin();
		
		Factura factura = new Factura();
		factura.setNumero(12);
		
		Domicilio domicilio = new Domicilio("san martin", 12222);
		
		Cliente cliente = new Cliente(123456778, "pablo", "munios", domicilio);
		
		domicilio.setCliente(cliente);
		
		factura.setCliente(cliente);
		
		Categoria perecederos = new Categoria("perecederos");
		Categoria lacteos = new Categoria("lacteos");
		Categoria limpieza = new Categoria("limpieza");
		
		Articulo art1 = new Articulo(200, "Yogur frutilla", 20);
		Articulo art2 = new Articulo(300, "deterjente", 80);
		
		art1.getCategorias().add(perecederos);
		art1.getCategorias().add(lacteos);
		lacteos.getArticulos().add(art1);
		perecederos.getArticulos().add(art1);
		
		art2.getCategorias().add(limpieza);
		limpieza.getArticulos().add(art2);
		
		DetalleFactura detalle1 = new DetalleFactura();
		detalle1.setArticulo(art1);
		detalle1.setCantidad(2);
		detalle1.setSubtotal(40);
		
		art1.getDetalle_f().add(detalle1);
		factura.getDetalle_f().add(detalle1);
		detalle1.setFactura(factura);
		
		DetalleFactura detalle2 = new DetalleFactura();
		detalle2.setArticulo(art2);
		detalle2.setCantidad(1);
		detalle2.setSubtotal(80);
		
		art2.getDetalle_f().add(detalle2);
		factura.getDetalle_f().add(detalle2);
		
		detalle2.setFactura(factura);
		
		factura.setTotal("120");
		
		em.persist(factura);
		
		em.getTransaction().commit();
		
		em.close(); 
	}

}
