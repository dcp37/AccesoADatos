/**
 * 
 */
package Procedimientos;

import java.util.Scanner;

/**
 * @author David♥
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Scanner porc = new Scanner(System.in);
		ConexionBD c = new ConexionBD();
		c.conexion();
		c.incrementaPrecioCategoria(s.nextInt(), porc.nextInt());
		s.close();
		porc.close();
		c.desconexion();
	}

}
