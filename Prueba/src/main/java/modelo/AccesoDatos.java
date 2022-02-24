/**
 * 
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author David♥
 *
 */
public class AccesoDatos {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String database = "profesores";
	private static String hostname = "localhost";
	private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database
			+ "?serverTimezone=Europe/Madrid";
	private static String username = "root";
	private static String password = "root";
	private Connection conecta;

	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}

	public void desconectar() throws SQLException, ClassNotFoundException {
		conecta = null;
	}

	public boolean insertarEmpleados(Integer idEmpleado, String apellidos, String nombre, String cargo,
			String tratamiento, Date fechaNacimiento, Date fechaContratacion, String direccion, String ciudad,
			String region, String codPostal, String pais, String telefono, String extension, String foto, String notas,
			Integer jefe) {
		try {
			String sql = "INSERT INTO empleados values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement inserta = conecta.prepareStatement(sql);
			inserta.setInt(1, idEmpleado);
			inserta.setString(2, apellidos);
			inserta.setString(3, nombre);
			inserta.setString(4, cargo);
			inserta.setString(5, tratamiento);
			inserta.setDate(6, fechaNacimiento);
			inserta.setDate(7, fechaContratacion);
			inserta.setString(8, direccion);
			inserta.setString(9, ciudad);
			inserta.setString(10, region);
			inserta.setString(11, codPostal);
			inserta.setString(12, pais);
			inserta.setString(13, telefono);
			inserta.setString(14, extension);
			inserta.setString(15, foto);
			inserta.setString(16, notas);
			inserta.setInt(17, jefe);
			inserta.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean borrarEmpleado(Integer idEmpleado) {
		try {
			String sql = "DELETE FROM empleados where idEmpleado = ?";
			PreparedStatement borra = conecta.prepareStatement(sql);
			borra.setInt(1, idEmpleado);
			borra.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean modificarEmpleado(Integer idEmpleado, String apellidos, String nombre, String cargo,
			String tratamiento, Date fechaNacimiento, Date fechaContratacion, String direccion, String ciudad,
			String region, String codPostal, String pais, String telefono, String extension, String foto, String notas,
			Integer jefe) {
		try {
			String sql = "UPDATE empleados set apellidos = ?, nombre = ?, cargo = ?, tratamiento = ?, fechaNacimiento = ?,"
					+ "fechaContratacion = ?,direccion = ?,ciudad = ?,region = ?,codPostal = ?,pais = ?,telefono = ?,extension = ?"
					+ ",foto = ?,notas = ?,jefe = ? WHERE idEmpleado = ?";
			PreparedStatement modifica = conecta.prepareStatement(sql);
			modifica.setString(1, apellidos);
			modifica.setString(2, nombre);
			modifica.setString(3, nombre);
			modifica.setString(4, cargo);
			modifica.setString(5, tratamiento);
			modifica.setDate(6, fechaNacimiento);
			modifica.setDate(7, fechaContratacion);
			modifica.setString(8, direccion);
			modifica.setString(9, ciudad);
			modifica.setString(10, region);
			modifica.setString(11, codPostal);
			modifica.setString(12, pais);
			modifica.setString(13, telefono);
			modifica.setString(14, extension);
			modifica.setString(15, foto);
			modifica.setString(16, notas);
			modifica.setInt(17, idEmpleado);
			modifica.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}

	}

	public ArrayList<Empleados> consultarTodosEmpleados() {
		ArrayList<Empleados> listaEmpleados = new ArrayList<Empleados>();
		try {
			PreparedStatement consulta = conecta.prepareStatement("SELECT * FROM empleados");
			ResultSet reg = consulta.executeQuery();
			while (reg.next()) {
				Empleados e = new Empleados(reg.getInt(1), reg.getString(2), reg.getString(3), reg.getString(4),
						reg.getString(5), reg.getDate(6), reg.getDate(7), reg.getString(8), reg.getString(9),
						reg.getString(10), reg.getString(11), reg.getString(12), reg.getString(13), reg.getString(14),
						reg.getString(15), reg.getString(16), reg.getInt(17));
				listaEmpleados.add(e);
			}
			consulta.close();
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		}
		return listaEmpleados;
	}

	public Empleados consultarUnEmpleado(int idEmpleado) {
		try {
			PreparedStatement consulta = conecta.prepareStatement("SELECT * FROM empleados WHERE idEmpleado = ?");
			consulta.setInt(1, idEmpleado);
			ResultSet reg = consulta.executeQuery();
			Empleados p = null;
			if (reg.next()) {
				p = new Empleados(reg.getInt(1), reg.getString(2), reg.getString(3), reg.getString(4), reg.getString(5),
						reg.getDate(6), reg.getDate(7), reg.getString(8), reg.getString(9), reg.getString(10),
						reg.getString(11), reg.getString(12), reg.getString(13), reg.getString(14), reg.getString(15),
						reg.getString(16), reg.getInt(17));
			}
			consulta.close();
			return p;
		} catch (SQLException e) {
			System.out.println("error al realizar la consulta" + e.getMessage());
			return null;
		}
	}

}
