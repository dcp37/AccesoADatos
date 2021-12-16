/**
 * 
 */
package tutorial;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author David♥
 *
 */
public class Main01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("db/p2.odb");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Point> typedQuery = em.createQuery("SELECT p FROM Point p", Point.class);
		List<Point> lista = typedQuery.getResultList();
		em.getTransaction().begin();
		for (Point point : lista) {
			if (point.getX() >= 100) {
				em.remove(point);
			} else {
				point.setX(point.getX() + 100);
			}			
		}
		em.getTransaction().commit();
		typedQuery = em.createQuery("SELECT p FROM Point p", Point.class);
		lista = typedQuery.getResultList();
		em.close();
		emf.close();
	}

}
