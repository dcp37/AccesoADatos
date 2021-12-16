/**
 * 
 */
package ejemplo1;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author David♥
 *
 */
@Entity
public class EmpleadosEntity {
	@Id
	private int empnoId;
	private String nombre;
	private String oficio;
	private EmpleadosEntity dirId;
	private Date alta;
	private Integer salario;
	private Integer comision;
	@ManyToOne
	private DepartamentosEntity departamento;

	//
	/**
	 * @param empnoId      Identificador del Empleado
	 * @param nombre       Nombre del Empleado
	 * @param oficio       Oficio que ocupa el Empleado
	 * @param dirId        Director de éste Empleado
	 * @param alta         Fecha de alta en la BD
	 * @param salario      Salario que cobra este Empleado
	 * @param comision     Comisión que cobra el Empleado
	 * @param departamento Departamento al que pertenece el Empleado
	 */
	public EmpleadosEntity(int empnoId, String nombre, String oficio, EmpleadosEntity dirId, Date alta, Integer salario,
			Integer comision, DepartamentosEntity departamento) {
		this.empnoId = empnoId;
		this.nombre = nombre;
		this.oficio = oficio;
		this.dirId = dirId;
		this.alta = alta;
		this.salario = salario;
		this.comision = comision;
		this.departamento = departamento;
	}

	/**
	 * @return the empnoId
	 */
	public int getEmpnoId() {
		return empnoId;
	}

	/**
	 * @param empnoId the empnoId to set
	 */
	public void setEmpnoId(int empnoId) {
		this.empnoId = empnoId;
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
	 * @return the oficio
	 */
	public String getOficio() {
		return oficio;
	}

	/**
	 * @param oficio the oficio to set
	 */
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	/**
	 * @return the dirId
	 */
	public EmpleadosEntity getDirId() {
		return dirId;
	}

	/**
	 * @param dirId the dirId to set
	 */
	public void setDirId(EmpleadosEntity dirId) {
		this.dirId = dirId;
	}

	/**
	 * @return the alta
	 */
	public Date getAlta() {
		return alta;
	}

	/**
	 * @param alta the alta to set
	 */
	public void setAlta(Date alta) {
		this.alta = alta;
	}

	/**
	 * @return the salario
	 */
	public Integer getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	/**
	 * @return the comision
	 */
	public Integer getComision() {
		return comision;
	}

	/**
	 * @param comision the comision to set
	 */
	public void setComision(Integer comision) {
		this.comision = comision;
	}

	/**
	 * @return the departamento
	 */
	public DepartamentosEntity getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(DepartamentosEntity departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "EmpleadosEntity [empnoId=" + empnoId + ", nombre=" + nombre + ", oficio=" + oficio + ", dirId=" + dirId
				+ ", alta=" + alta + ", salario=" + salario + ", comision=" + comision + ", departamento="
				+ departamento + "]";
	}

}
