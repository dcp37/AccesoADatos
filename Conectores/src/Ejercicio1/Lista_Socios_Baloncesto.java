/**
 * 
 */
package Ejercicio1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author David♥
 *
 */
public class Lista_Socios_Baloncesto {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		AccesoBD abd = new AccesoBD();
		ResultSet rs;
		Scanner s = new Scanner(System.in);
		System.out.println("Introduce una localidad Española: ");
		String localidad = s.next();
		s.close();
		abd.conexion();
		rs = abd.consultaLocalidad(localidad);
		rs.close();
	}

}
