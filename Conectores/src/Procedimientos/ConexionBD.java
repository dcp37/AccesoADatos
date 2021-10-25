/**
 * 
 */
package Procedimientos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author David♥
 *
 */
public class ConexionBD {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String database = "baloncesto";
	private String hostname = "localhost";
	private String port = "3306";
	private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
	private String username = "root";
	private String password = "root";

	private Connection conecta;

	public void conexion() {
		try {
			Class.forName(driver);
			conecta = DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void incrementaPrecioCategoria(int cat, int porcentaje) {
		
	}

	public void desconexion() {
		try {
			if (conecta != null) {
				conecta.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
