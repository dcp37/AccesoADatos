/**
 * 
 */
package modelo;

import java.sql.Date;

/**
 * @author David♥
 *
 */
public class Pedidos {
	private int IdPedido;
	private String IdCliente;
	private int IdEmpleado;
	private Date FechaPedido;
	private Date FechaEntrega;
	private Date FechaEnvio;
	private int FormaEnvio;
	private double Cargo;
	private String Destinatario;
	private String DireccionDestinatario;
	private String CiudadDestinatario;
	private String RegionDestinanario;
	private String CodPostalDestinatario;
	private String PaisDestinatario;

	/**
	 * @param idPedido
	 * @param idCliente
	 * @param idEmpleado
	 * @param fechaPedido
	 * @param fechaEntrega
	 * @param fechaEnvio
	 * @param formaEnvio
	 * @param cargo
	 * @param destinatario
	 * @param direccionDestinatario
	 * @param ciudadDestinatario
	 * @param regionDestinanario
	 * @param codPostalDestinatario
	 * @param paisDestinatario
	 */
	public Pedidos(int idPedido, String idCliente, int idEmpleado, Date fechaPedido, Date fechaEntrega, Date fechaEnvio,
			int formaEnvio, double cargo, String destinatario, String direccionDestinatario, String ciudadDestinatario,
			String regionDestinanario, String codPostalDestinatario, String paisDestinatario) {
		IdPedido = idPedido;
		IdCliente = idCliente;
		IdEmpleado = idEmpleado;
		FechaPedido = fechaPedido;
		FechaEntrega = fechaEntrega;
		FechaEnvio = fechaEnvio;
		FormaEnvio = formaEnvio;
		Cargo = cargo;
		Destinatario = destinatario;
		DireccionDestinatario = direccionDestinatario;
		CiudadDestinatario = ciudadDestinatario;
		RegionDestinanario = regionDestinanario;
		CodPostalDestinatario = codPostalDestinatario;
		PaisDestinatario = paisDestinatario;
	}

	/**
	 * @return the idPedido
	 */
	public int getIdPedido() {
		return IdPedido;
	}

	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
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
	 * @return the fechaPedido
	 */
	public Date getFechaPedido() {
		return FechaPedido;
	}

	/**
	 * @param fechaPedido the fechaPedido to set
	 */
	public void setFechaPedido(Date fechaPedido) {
		FechaPedido = fechaPedido;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return FechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		FechaEntrega = fechaEntrega;
	}

	/**
	 * @return the fechaEnvio
	 */
	public Date getFechaEnvio() {
		return FechaEnvio;
	}

	/**
	 * @param fechaEnvio the fechaEnvio to set
	 */
	public void setFechaEnvio(Date fechaEnvio) {
		FechaEnvio = fechaEnvio;
	}

	/**
	 * @return the formaEnvio
	 */
	public int getFormaEnvio() {
		return FormaEnvio;
	}

	/**
	 * @param formaEnvio the formaEnvio to set
	 */
	public void setFormaEnvio(int formaEnvio) {
		FormaEnvio = formaEnvio;
	}

	/**
	 * @return the cargo
	 */
	public double getCargo() {
		return Cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(double cargo) {
		Cargo = cargo;
	}

	/**
	 * @return the destinatario
	 */
	public String getDestinatario() {
		return Destinatario;
	}

	/**
	 * @param destinatario the destinatario to set
	 */
	public void setDestinatario(String destinatario) {
		Destinatario = destinatario;
	}

	/**
	 * @return the direccionDestinatario
	 */
	public String getDireccionDestinatario() {
		return DireccionDestinatario;
	}

	/**
	 * @param direccionDestinatario the direccionDestinatario to set
	 */
	public void setDireccionDestinatario(String direccionDestinatario) {
		DireccionDestinatario = direccionDestinatario;
	}

	/**
	 * @return the ciudadDestinatario
	 */
	public String getCiudadDestinatario() {
		return CiudadDestinatario;
	}

	/**
	 * @param ciudadDestinatario the ciudadDestinatario to set
	 */
	public void setCiudadDestinatario(String ciudadDestinatario) {
		CiudadDestinatario = ciudadDestinatario;
	}

	/**
	 * @return the regionDestinanario
	 */
	public String getRegionDestinanario() {
		return RegionDestinanario;
	}

	/**
	 * @param regionDestinanario the regionDestinanario to set
	 */
	public void setRegionDestinanario(String regionDestinanario) {
		RegionDestinanario = regionDestinanario;
	}

	/**
	 * @return the codPostalDestinatario
	 */
	public String getCodPostalDestinatario() {
		return CodPostalDestinatario;
	}

	/**
	 * @param codPostalDestinatario the codPostalDestinatario to set
	 */
	public void setCodPostalDestinatario(String codPostalDestinatario) {
		CodPostalDestinatario = codPostalDestinatario;
	}

	/**
	 * @return the paisDestinatario
	 */
	public String getPaisDestinatario() {
		return PaisDestinatario;
	}

	/**
	 * @param paisDestinatario the paisDestinatario to set
	 */
	public void setPaisDestinatario(String paisDestinatario) {
		PaisDestinatario = paisDestinatario;
	}

	@Override
	public String toString() {
		return "Pedidos [IdPedido=" + IdPedido + ", IdCliente=" + IdCliente + ", IdEmpleado=" + IdEmpleado
				+ ", FechaPedido=" + FechaPedido + ", FechaEntrega=" + FechaEntrega + ", FechaEnvio=" + FechaEnvio
				+ ", FormaEnvio=" + FormaEnvio + ", Cargo=" + Cargo + ", Destinatario=" + Destinatario
				+ ", DireccionDestinatario=" + DireccionDestinatario + ", CiudadDestinatario=" + CiudadDestinatario
				+ ", RegionDestinanario=" + RegionDestinanario + ", CodPostalDestinatario=" + CodPostalDestinatario
				+ ", PaisDestinatario=" + PaisDestinatario + "]";
	}

}
