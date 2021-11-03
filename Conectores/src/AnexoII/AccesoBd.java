/**
 * 
 */
package AnexoII;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author David♥
 *
 */
public class AccesoBd {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String database = "demodb";
	private String hostname = "localhost";
	private String port = "3306";
	private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
	private String username = "root";
	private String password = "root";

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

	public Empleado busquedaPorCodigo(int codigo) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM " + this.database.toString() + ";";
		try {
			pstmt = conecta.prepareStatement(sql);

			sql = sql + " WHERE " + pstmt.getMetaData().getColumnName(1) + " =?";
			pstmt = conecta.prepareStatement(sql);
			pstmt.setInt(1, codigo);

			return (Empleado) pstmt.executeQuery();

		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			return null;
		}
	}
}
