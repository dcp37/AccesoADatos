package Ejercicio3;
/*
 * Revisado para versi�n 8.19 de MySQL 
 * Alberto Carrera Mart�n
 * 29 febrero 2020
 * 28 de abril 2021
 */

import java.sql.*;

public class AccesoBdatos {
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
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet consultaLocalidad(String localidad) {
		try {
			PreparedStatement ps;
			String consultaSQL = "SELECT * FROM Socio";
			if (localidad.isEmpty())
				ps = conecta.prepareStatement(consultaSQL);
			else {
				consultaSQL = " SELECT * FROM Socio WHERE localidad = ?";
				ps = conecta.prepareStatement(consultaSQL);
				ps.setString(1, localidad);
			}
			return (ps.executeQuery());
		} catch (SQLException e) {
			return null;
		}
	}

	public void desconecxion() throws SQLException {
		if (conecta != null) {
			conecta.close();
		}
	}
}