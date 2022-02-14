/**
 * 
 */
package ejemplo1;

/**
 * @author David♥
 *
 */
public class Ejercicios9_2ªparte {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccesoDatos acc = new AccesoDatos();
		acc.conectar();
		//System.out.println(acc.incrementarSalario(80));
		//System.out.println(acc.incrementarSalarioOficio("Empleado", 10));
		//System.out.println(acc.incrementarSalarioDepartamento(20, 50));
		//System.out.println(acc.borrarEmpleado(1039));
		acc.desconectar();
	}

}
