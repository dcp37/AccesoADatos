/**
 * 
 */
package modelo;

/**
 * @author David♥
 *
 */
public class Clientes {
	private String IdCliente;
	private String NombreCompañia;
	private String NombreContacto;
	private String Direccion;
	private String Ciudad;
	private String Region;
	private String CodPostal;
	private String Pais;
	private String Telefono;
	private String Fax;

	/**
	 * @param idCliente
	 * @param nombreCompañia
	 * @param nombreContacto
	 * @param direccion
	 * @param ciudad
	 * @param region
	 * @param codPostal
	 * @param pais
	 * @param telefono
	 * @param fax
	 */
	public Clientes(String idCliente, String nombreCompañia, String nombreContacto, String direccion, String ciudad,
			String region, String codPostal, String pais, String telefono, String fax) {
		IdCliente = idCliente;
		NombreCompañia = nombreCompañia;
		NombreContacto = nombreContacto;
		Direccion = direccion;
		Ciudad = ciudad;
		Region = region;
		CodPostal = codPostal;
		Pais = pais;
		Telefono = telefono;
		Fax = fax;
	}

	/**
	 * @return the idCliente
	 */
	public String getIdCliente() {
		return IdCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	/**
	 * @return the nombreCompañia
	 */
	public String getNombreCompañia() {
		return NombreCompañia;
	}

	/**
	 * @param nombreCompañia the nombreCompañia to set
	 */
	public void setNombreCompañia(String nombreCompañia) {
		NombreCompañia = nombreCompañia;
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

	@Override
	public String toString() {
		return "Clientes [IdCliente=" + IdCliente + ", NombreCompañia=" + NombreCompañia + ", NombreContacto="
				+ NombreContacto + ", Direccion=" + Direccion + ", Ciudad=" + Ciudad + ", Region=" + Region
				+ ", CodPostal=" + CodPostal + ", Pais=" + Pais + ", Telefono=" + Telefono + ", Fax=" + Fax + "]";
	}
}
