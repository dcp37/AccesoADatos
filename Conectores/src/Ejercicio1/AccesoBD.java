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
		PreparedStatement pstm = null;
		String consultaSQL = "SELECT * FROM Socio";
		if (loc.isEmpty()) {
			try {
				pstm = conecta.prepareStatement(consultaSQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			consultaSQL = "SELECT * FROM Socio WHERE  localidad = ?";
			try {
				pstm = conecta.prepareStatement(consultaSQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstm.setString(1, loc);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				return pstm.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public void imprimeDatos(ResultSet rs) {
		int filas;
		System.out.println();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
