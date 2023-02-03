package programa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class principal {

	/*
	 * en la relaciones many to one, la relacion se establece desde el lado many
	 */
	
	private static EntityManagerFactory emf = null;
	
	public static void main(String[] args) {
		
		pruebaEmpresa8 p8 = new pruebaEmpresa8();
		p8.hacerCosas();
		//DatabaseManagerSwing.main(new String[] {"--url","jdbc:hsqldb:file:/home/paulo/Escritorio/jpa/db","--user","","--password",""});
		principal.emf.close();
		
	}
	
	public static EntityManagerFactory crearEntityManagerFactory() {
		if (emf == null) {
			principal.emf = Persistence.createEntityManagerFactory("ujyt");
		}
		return principal.emf;
	}
	
	public static void cerrarEntityManagerFactory() {
		principal.emf.close();
		principal.emf = null;
	}

	public static void pausa() {
		System.out.println("Press enter to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
