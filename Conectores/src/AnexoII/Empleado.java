/**
 * 
 */
package AnexoII;

import java.sql.Date;

/**
 * @author David♥
 *
 */
public class Empleado {
	private int empno;
	private String ename;
	private String ejob;
	private int ejefe;
	private Date eantiguedad;
	private double esalario;
	private double ecomm;
	private int edept;

	/**
	 * 
	 */
	public Empleado() {
	}

	/**
	 * @param empno
	 * @param ename
	 * @param ejob
	 * @param ejefe
	 * @param eantiguedad
	 * @param esalario
	 * @param ecomm
	 * @param edept
	 */
	public Empleado(int empno, String ename, String ejob, int ejefe, Date eantiguedad, double esalario, double ecomm,
			int edept) {
		this.empno = empno;
		this.ename = ename;
		this.ejob = ejob;
		this.ejefe = ejefe;
		this.eantiguedad = eantiguedad;
		this.esalario = esalario;
		this.ecomm = ecomm;
		this.edept = edept;
	}

	/**
	 * @return the empno
	 */
	public int getEmpno() {
		return empno;
	}

	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(int empno) {
		this.empno = empno;
	}

	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * @return the ejob
	 */
	public String getEjob() {
		return ejob;
	}

	/**
	 * @param ejob the ejob to set
	 */
	public void setEjob(String ejob) {
		this.ejob = ejob;
	}

	/**
	 * @return the ejefe
	 */
	public int getEjefe() {
		return ejefe;
	}

	/**
	 * @param ejefe the ejefe to set
	 */
	public void setEjefe(int ejefe) {
		this.ejefe = ejefe;
	}

	/**
	 * @return the eantiguedad
	 */
	public Date getEantiguedad() {
		return eantiguedad;
	}

	/**
	 * @param eantiguedad the eantiguedad to set
	 */
	public void setEantiguedad(Date eantiguedad) {
		this.eantiguedad = eantiguedad;
	}

	/**
	 * @return the esalario
	 */
	public double getEsalario() {
		return esalario;
	}

	/**
	 * @param esalario the esalario to set
	 */
	public void setEsalario(double esalario) {
		this.esalario = esalario;
	}

	/**
	 * @return the ecomm
	 */
	public double getEcomm() {
		return ecomm;
	}

	/**
	 * @param ecomm the ecomm to set
	 */
	public void setEcomm(double ecomm) {
		this.ecomm = ecomm;
	}

	/**
	 * @return the edept
	 */
	public int getEdept() {
		return edept;
	}

	/**
	 * @param edept the edept to set
	 */
	public void setEdept(int edept) {
		this.edept = edept;
	}

	@Override
	public String toString() {
		return "Empleado [empno=" + empno + ", ename=" + ename + ", ejob=" + ejob + ", ejefe=" + ejefe
				+ ", eantiguedad=" + eantiguedad + ", esalario=" + esalario + ", ecomm=" + ecomm + ", edept=" + edept
				+ "]";
	}

}
