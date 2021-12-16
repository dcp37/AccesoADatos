/**
 * 
 */
package ejemplo1;

/**
 * @author David♥
 *
 */
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DepartamentosEntity {
	@Id
	private int dptoId;
	private String nombre;
	private String localidad;
	@OneToMany(mappedBy = "departamento")
	private Set<EmpleadosEntity> empleados = new HashSet<EmpleadosEntity>();

	/**
	 * @param dptoId    Identificador del Departamento
	 * @param nombre    Nombre del Departamento
	 * @param localidad Lugar en el que se encuentra el Departamento
	 */
	public DepartamentosEntity(int dptoId, String nombre, String localidad) {
		this.dptoId = dptoId;
		this.nombre = nombre;
		this.localidad = localidad;
	}

	/**
	 * @return the dptoId
	 */
	public int getDptoId() {
		return dptoId;
	}

	/**
	 * @param dptoId the dptoId to set
	 */
	public void setDptoId(int dptoId) {
		this.dptoId = dptoId;
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
	 * @return the empleados
	 */
	public Set<EmpleadosEntity> getEmpleados() {
		return empleados;
	}

	/**
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(Set<EmpleadosEntity> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "DepartamentosEntity [dptoId=" + dptoId + ", nombre=" + nombre + ", localidad=" + localidad
				+ ", empleados=" + empleados + "]";
	}

}
