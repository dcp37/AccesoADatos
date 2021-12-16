/**
 * 
 */
package tutorial;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author DAM2Alu2
 *
 */
public class Main00 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("db/p2.odb");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		for (int i = 0; i < 1000; i++) {
			Point p = new Point(i, i);
			em.persist(p);
		}
		em.getTransaction().commit();
		Query q1 = em.createQuery("SELECT COUNT (p) FROM Point p");
		System.out.println("Total puntos: " + q1.getSingleResult());

		Query q2 = em.createQuery("SELECT AVG (p.x) FROM Point p");
		System.out.println("Media de X: " + q2.getSingleResult());

		TypedQuery<Point> typedquery = em.createQuery("SELECT p FROM Point p", Point.class);
		List<Point> resultados = typedquery.getResultList();
		for (Point point : resultados) {
			System.out.println(point);
		}
		em.close();
		emf.close();
	}

}
