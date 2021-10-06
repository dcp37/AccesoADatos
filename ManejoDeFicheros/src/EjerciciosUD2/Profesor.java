package EjerciciosUD2;

import java.io.Serializable;

public class Profesor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int antiguedad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", antiguedad=" + antiguedad + "]";
	}

	public Profesor(String nombre, int antiguedad) {
		this.nombre = nombre;
		this.antiguedad = antiguedad;
	}

}
