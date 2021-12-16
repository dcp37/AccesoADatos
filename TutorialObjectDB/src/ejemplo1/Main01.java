/**
 * 
 */
package ejemplo1;

/**
 * @author David♥
 *
 */
public class Main01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AccesoDatos abd = new AccesoDatos();
		abd.conectar();
		abd.imprimeDepartamento(90);
		abd.imprimeDepartamento(40);
		abd.imprimeDepartamento(10);
		System.out.println(abd.insertarDepartamento(new DepartamentosEntity(60, "Recursos Humanos", "Chimillas")));
		System.out.println(abd.insertarDepartamento(new DepartamentosEntity(60, "Recursos Humanos", "Chimillas")));
		abd.imprimeDepartamento(60);

		System.out.println(abd.modificarDepartamento(new DepartamentosEntity(88, "RRHH", "Huerrios")));
		System.out.println(abd.modificarDepartamento(new DepartamentosEntity(60, "RRHH", "Esquedas")));
		abd.imprimeDepartamento(60);

		abd.borrarDepartamento(88); // false no existe
		abd.borrarDepartamento(60); // true
		abd.borrarDepartamento(10); // false pues tiene empleados

		abd.imprimeDepartamento(10);

		abd.pruebaJPQL();

		abd.desconectar();

	}

}
