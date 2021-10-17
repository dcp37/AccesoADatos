package Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author David♥
 *
 */
public class AccesoBD {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String database = "baloncesto";
	private String hostname = "localhost";
	private String port = "3306";
	private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
	private String username = "root";
	private String password = "";

	private Connection conecta;

	public void conexion() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conecta = DriverManager.getConnection(url, username, password);
		} catch (SQLException ae) {
			// TODO Auto-generated catch block
			ae.printStackTrace();
		}

	}

	public void desconexion() {
		if (conecta != null) {
			try {
				conecta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ResultSet consultaLocalidad(String loc) {
		try {
			PreparedStatement pstm;
			String consultaSQL = "SELECT * FROM Socio";
			if (loc.isEmpty()) {
				pstm = conecta.prepareStatement(consultaSQL);
			} else {
				consultaSQL = "SELECT * FROM Socio WHERE  localidad = ?";
				pstm = conecta.prepareStatement(consultaSQL);
				pstm.setString(1, loc);
			}
			return (pstm.executeQuery());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public void imprimeDatos(ResultSet rs) {
		// imprime datos del result set
		int filas = 0;
		try {
			rs.last();
			filas = rs.getRow();
			rs.first();
			System.out.println(filas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
