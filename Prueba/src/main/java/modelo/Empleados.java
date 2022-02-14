/**
 * 
 */
package modelo;

import java.sql.Date;

/**
 * @author David♥
 *
 */
public class Empleados {
	private int IdEmpleado;
	private String Apellidos;
	private String Nombre;
	private String Cargo;
	private String Tratamiento;
	private Date FechaNacimiento;
	private Date FechaContratacion;
	private String Direccion;
	private String Ciudad;
	private String Region;
	private String CodPostal;
	private String Pais;
	private String TelDomicilio;
	private String Extension;
	private String Foto;
	private String Notas;
	private int Jefe;

	/**
	 * @param idEmpleado
	 * @param apellidos
	 * @param nombre
	 * @param cargo
	 * @param tratamiento
	 * @param fechaNacimiento
	 * @param fechaContratacion
	 * @param direccion
	 * @param ciudad
	 * @param region
	 * @param codPostal
	 * @param pais
	 * @param telDomicilio
	 * @param extension
	 * @param foto
	 * @param notas
	 * @param jefe
	 */
	public Empleados(int idEmpleado, String apellidos, String nombre, String cargo, String tratamiento,
			Date fechaNacimiento, Date fechaContratacion, String direccion, String ciudad, String region,
			String codPostal, String pais, String telDomicilio, String extension, String foto, String notas, int jefe) {
		IdEmpleado = idEmpleado;
		Apellidos = apellidos;
		Nombre = nombre;
		Cargo = cargo;
		Tratamiento = tratamiento;
		FechaNacimiento = fechaNacimiento;
		FechaContratacion = fechaContratacion;
		Direccion = direccion;
		Ciudad = ciudad;
		Region = region;
		CodPostal = codPostal;
		Pais = pais;
		TelDomicilio = telDomicilio;
		Extension = extension;
		Foto = foto;
		Notas = notas;
		Jefe = jefe;
	}

	/**
	 * @return the idEmpleado
	 */
	public int getIdEmpleado() {
		return IdEmpleado;
	}

	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(int idEmpleado) {
		IdEmpleado = idEmpleado;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return Apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return Cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	/**
	 * @return the tratamiento
	 */
	public String getTratamiento() {
		return Tratamiento;
	}

	/**
	 * @param tratamiento the tratamiento to set
	 */
	public void setTratamiento(String tratamiento) {
		Tratamiento = tratamiento;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the fechaContratacion
	 */
	public Date getFechaContratacion() {
		return FechaContratacion;
	}

	/**
	 * @param fechaContratacion the fechaContratacion to set
	 */
	public void setFechaContratacion(Date fechaContratacion) {
		FechaContratacion = fechaContratacion;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return Direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return Ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return Region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		Region = region;
	}

	/**
	 * @return the codPostal
	 */
	public String getCodPostal() {
		return CodPostal;
	}

	/**
	 * @param codPostal the codPostal to set
	 */
	public void setCodPostal(String codPostal) {
		CodPostal = codPostal;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return Pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		Pais = pais;
	}

	/**
	 * @return the telDomicilio
	 */
	public String getTelDomicilio() {
		return TelDomicilio;
	}

	/**
	 * @param telDomicilio the telDomicilio to set
	 */
	public void setTelDomicilio(String telDomicilio) {
		TelDomicilio = telDomicilio;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return Extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		Extension = extension;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return Foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		Foto = foto;
	}

	/**
	 * @return the notas
	 */
	public String getNotas() {
		return Notas;
	}

	/**
	 * @param notas the notas to set
	 */
	public void setNotas(String notas) {
		Notas = notas;
	}

	/**
	 * @return the jefe
	 */
	public int getJefe() {
		return Jefe;
	}

	/**
	 * @param jefe the jefe to set
	 */
	public void setJefe(int jefe) {
		Jefe = jefe;
	}

	@Override
	public String toString() {
		return "Empleados [IdEmpleado=" + IdEmpleado + ", Apellidos=" + Apellidos + ", Nombre=" + Nombre + ", Cargo="
				+ Cargo + ", Tratamiento=" + Tratamiento + ", FechaNacimiento=" + FechaNacimiento
				+ ", FechaContratacion=" + FechaContratacion + ", Direccion=" + Direccion + ", Ciudad=" + Ciudad
				+ ", Region=" + Region + ", CodPostal=" + CodPostal + ", Pais=" + Pais + ", TelDomicilio="
				+ TelDomicilio + ", Extension=" + Extension + ", Foto=" + Foto + ", Notas=" + Notas + ", Jefe=" + Jefe
				+ "]";
	}

}
