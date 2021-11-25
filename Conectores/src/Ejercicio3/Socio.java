package Ejercicio3;

/**
 * @author David♥
 *
 */
public class Socio {
	private int socioId;
	private String nombre;
	private int estatura;
	private int edad;
	private String localidad;

	/**
	 * 
	 */
	public Socio() {
		super();
	}

	/**
	 * @param socioId
	 * @param nombre
	 * @param estatura
	 * @param edad
	 * @param localidad
	 */
	public Socio(int socioId, String nombre, int estatura, int edad, String localidad) {
		this.socioId = socioId;
		this.nombre = nombre;
		this.estatura = estatura;
		this.edad = edad;
		this.localidad = localidad;
	}

	/**
	 * @return the socioId
	 */
	public int getSocioId() {
		return socioId;
	}

	/**
	 * @param socioId the socioId to set
	 */
	public void setSocioId(int socioId) {
		this.socioId = socioId;
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

	@Override
	public String toString() {
		return "Socio [socioId=" + socioId + ", nombre=" + nombre + ", estatura=" + estatura + ", edad=" + edad
				+ ", localidad=" + localidad + "]";
	}

}
