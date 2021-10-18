/**
 * 
 */
package Ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author David♥
 *
 */
public class AccesoBaseDatos {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String database = "";
	private String hostname = "localhost";
	private String port = "3306";
	private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
	private String username = "root";
	private String password = "";

	private Connection conecta;

	public void conexion() {
		try {
			Class.forName(driver);
			conecta = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
