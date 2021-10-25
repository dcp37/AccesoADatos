/**
 * 
 */
package Procedimientos;

import java.util.Scanner;

/**
 * @author David♥
 *
 */
public class Main3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1 = new Scanner(System.in), s2 = new Scanner(System.in);
		System.out.println("Introduce un número de categoría y un porcentaje");
		int categ = s1.nextInt(), porc = s2.nextInt();
		ConexionBD c = new ConexionBD();
		c.conexion();
		if (c.incrementaPrecioCategoria(categ, porc) == false) {
			System.out.println("se ha actualizado la categoría " + categ);
		} else {
			System.out.println("No se actualizó ningún producto con la categoría --> " + categ);
		}
		s1.close();
		s2.close();
		c.desconexion();
	}

}
