/**
 * 
 */
package modelo;

/**
 * @author David♥
 *
 */
public class Proveedores {
	private int IdProveedor;
	private String NombreCompania;
	private String NombreContacto;
	private String CargoContacto;
	private String Direccion;
	private String Ciudad;
	private String Region;
	private String CodPostal;
	private String Pais;
	private String Telefono;
	private String Fax;
	private String PaginaPrincipal;

	/**
	 * @param idProveedor
	 * @param nombreCompania
	 * @param nombreContacto
	 * @param cargoContacto
	 * @param direccion
	 * @param ciudad
	 * @param region
	 * @param codPostal
	 * @param pais
	 * @param telefono
	 * @param fax
	 * @param paginaPrincipal
	 */
	public Proveedores(int idProveedor, String nombreCompania, String nombreContacto, String cargoContacto,
			String direccion, String ciudad, String region, String codPostal, String pais, String telefono, String fax,
			String paginaPrincipal) {
		IdProveedor = idProveedor;
		NombreCompania = nombreCompania;
		NombreContacto = nombreContacto;
		CargoContacto = cargoContacto;
		Direccion = direccion;
		Ciudad = ciudad;
		Region = region;
		CodPostal = codPostal;
		Pais = pais;
		Telefono = telefono;
		Fax = fax;
		PaginaPrincipal = paginaPrincipal;
	}

	/**
	 * @return the idProveedor
	 */
	public int getIdProveedor() {
		return IdProveedor;
	}

	/**
	 * @param idProveedor the idProveedor to set
	 */
	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
	}

	/**
	 * @return the nombreCompania
	 */
	public String getNombreCompania() {
		return NombreCompania;
	}

	/**
	 * @param nombreCompania the nombreCompania to set
	 */
	public void setNombreCompania(String nombreCompania) {
		NombreCompania = nombreCompania;
	}

	/**
	 * @return the nombreContacto
	 */
	public String getNombreContacto() {
		return NombreContacto;
	}

	/**
	 * @param nombreContacto the nombreContacto to set
	 */
	public void setNombreContacto(String nombreContacto) {
		NombreContacto = nombreContacto;
	}

	/**
	 * @return the cargoContacto
	 */
	public String getCargoContacto() {
		return CargoContacto;
	}

	/**
	 * @param cargoContacto the cargoContacto to set
	 */
	public void setCargoContacto(String cargoContacto) {
		CargoContacto = cargoContacto;
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
	 * @return the telefono
	 */
	public String getTelefono() {
		return Telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return Fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		Fax = fax;
	}

	/**
	 * @return the paginaPrincipal
	 */
	public String getPaginaPrincipal() {
		return PaginaPrincipal;
	}

	/**
	 * @param paginaPrincipal the paginaPrincipal to set
	 */
	public void setPaginaPrincipal(String paginaPrincipal) {
		PaginaPrincipal = paginaPrincipal;
	}

	@Override
	public String toString() {
		return "Proveedores [IdProveedor=" + IdProveedor + ", NombreCompania=" + NombreCompania + ", NombreContacto="
				+ NombreContacto + ", CargoContacto=" + CargoContacto + ", Direccion=" + Direccion + ", Ciudad="
				+ Ciudad + ", Region=" + Region + ", CodPostal=" + CodPostal + ", Pais=" + Pais + ", Telefono="
				+ Telefono + ", Fax=" + Fax + ", PaginaPrincipal=" + PaginaPrincipal + "]";
	}

}
