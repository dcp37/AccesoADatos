/**
 * 
 */
package Ejercicio1;

/**
 * @author David♥
 *
 */
public class Socio {
	private int socioID;
	private String nombre;
	private String localidad;
	private int edad;
	private int estatura;

	/**
	 * @param socioID
	 * @param nombre
	 * @param localidad
	 * @param edad
	 * @param estatura
	 */
	public Socio(int socioID, String nombre, String localidad, int edad, int estatura) {
		this.socioID = socioID;
		this.nombre = nombre;
		this.localidad = localidad;
		this.edad = edad;
		this.estatura = estatura;
	}

	/**
	 * 
	 */
	public Socio() {
	}

	/**
	 * @return the socioID
	 */
	public int getSocioID() {
		return socioID;
	}

	/**
	 * @param socioID the socioID to set
	 */
	public void setSocioID(int socioID) {
		this.socioID = socioID;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the estatura
	 */
	public int getEstatura() {
		return estatura;
	}

	/**
	 * @param estatura the estatura to set
	 */
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	@Override
	public String toString() {
		return "Socio [socioID=" + socioID + ", nombre=" + nombre + ", localidad=" + localidad + ", edad=" + edad
				+ ", estatura=" + estatura + "]";
	}

}
