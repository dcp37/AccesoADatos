/**
 * 
 */
package ejemplo1;

/**
 * @author David♥
 *
 */
public class Ejercicios_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccesoDatos accd = new AccesoDatos();
		accd.conectar();
		System.out.println("*********EJERCICIO 1****************************");
		accd.ejer8_1();
		System.out.println("*********EJERCICIO 2****************************");
		accd.ejer8_2();
		System.out.println("*********EJERCICIO 3****************************");
		accd.ejer8_3();
		System.out.println("*********EJERCICIO 4****************************");
		accd.ejer8_4();
		System.out.println("*********EJERCICIO 5****************************");
		accd.ejer8_5();
		System.out.println("*********EJERCICIO 6****************************");
		//accd.ejer8_6();
		System.out.println("*********EJERCICIO 7****************************");
		// accd.ejer8_7();
		System.out.println("*********EJERCICIO 8****************************");
		// accd.ejer8_8();
		System.out.println("*********EJERCICIO 9****************************");
		//accd.ejer8_9();
		System.out.println("*********EJERCICIO 10****************************");
		accd.ejer8_10();
		accd.desconectar();
	}

}
