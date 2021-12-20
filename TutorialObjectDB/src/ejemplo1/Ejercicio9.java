/**
 * 
 */
package ejemplo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author David♥
 *
 */
public class Ejercicio9 {

	private EntityManagerFactory emf;
	private EntityManager em;

	public void conectar() {
		emf = Persistence.createEntityManagerFactory("db/empleados.odb");
		em = emf.createEntityManager();
	}

	public void desconectar() {
		em.close();
		emf.close();
	}

	public int incrementarSalario(int cantidad) {
		em.getTransaction().begin();
		
		Query q = em.createQuery("UPDATE EmpleadosEntity SET salario = salario*" + cantidad);
		int filasModificadas = q.executeUpdate();
		em.getTransaction().commit();
		return filasModificadas;
	}

}
