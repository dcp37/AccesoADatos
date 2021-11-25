/**
 * 
 */
package Procedimientos;

import java.sql.*;

/**
 * @author David♥
 *
 */
public class ConexionBD {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String database = "pedidos";
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

	public boolean incrementaPrecioCategoria(int cat, int porcentaje) {
		try {
			CallableStatement callstmt = conecta.prepareCall("CALL incrementarPrecioCategoria(?,?,?)");
			callstmt.setInt(1, cat);
			callstmt.setInt(2, porcentaje);
			callstmt.registerOutParameter(3, Types.INTEGER);
			if (callstmt.execute()) {// true if the first result is a ResultSetobject;
										// false if the first result is an updatecount or there is no result
				System.out.println(callstmt.getInt(3));
				return true;
			} else {
				callstmt.close();
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return false;
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
