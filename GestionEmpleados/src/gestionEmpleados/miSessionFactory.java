/**
 * 
 */
package gestionEmpleados;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author David♥
 *
 */
public class miSessionFactory {

	private static SessionFactory sf;

	public static SessionFactory getSf() {
		if (sf == null) {
			Configuration config = new Configuration().configure();
			ServiceRegistry serReg = (ServiceRegistry) new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties()).build();
			sf = (SessionFactory) config.buildSessionFactory(serReg);
		}
		return sf;
	}

}
