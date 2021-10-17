/**
 * 
 */
package Ejercicio1;

import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author David♥
 *
 */
public class ListaSociosBaloncesto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccesoBD abd = new AccesoBD();
		ResultSet socios = null;
		abd.conexion();
		System.out.println("Busca una localidad española: ");
		Scanner s = new Scanner(System.in);
		String localidad = s.next();
		s.close();
		if (localidad.isEmpty()) {
			socios = abd.consultaLocalidad(localidad);
		}
		else {
			abd.imprimeDatos(socios);
		}
		abd.desconexion();
	
	}

}
