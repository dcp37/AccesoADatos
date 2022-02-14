/**
 * 
 */
package modelo;

/**
 * @author David♥
 *
 */
public class Productos {
	private int IdProducto;
	private String NombreProducto;
	private int IdProveedor;
	private int IdCategoria;
	private String CantidadUnidad;
	private double PrecioUnidad;
	private int UnidadesExistentes;
	private int UnidadesPedido;
	private int NivelNuevoPedido;
	private int Suspendido;

	/**
	 * @param idProducto
	 * @param nombreProducto
	 * @param idProveedor
	 * @param idCategoria
	 * @param cantidadUnidad
	 * @param precioUnidad
	 * @param unidadesExistentes
	 * @param unidadesPedido
	 * @param nivelNuevoPedido
	 * @param suspendido
	 */
	public Productos(int idProducto, String nombreProducto, int idProveedor, int idCategoria, String cantidadUnidad,
			double precioUnidad, int unidadesExistentes, int unidadesPedido, int nivelNuevoPedido, int suspendido) {
		IdProducto = idProducto;
		NombreProducto = nombreProducto;
		IdProveedor = idProveedor;
		IdCategoria = idCategoria;
		CantidadUnidad = cantidadUnidad;
		PrecioUnidad = precioUnidad;
		UnidadesExistentes = unidadesExistentes;
		UnidadesPedido = unidadesPedido;
		NivelNuevoPedido = nivelNuevoPedido;
		Suspendido = suspendido;
	}

	/**
	 * @return the idProducto
	 */
	public int getIdProducto() {
		return IdProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return NombreProducto;
	}

	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
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
	 * @return the idCategoria
	 */
	public int getIdCategoria() {
		return IdCategoria;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	/**
	 * @return the cantidadUnidad
	 */
	public String getCantidadUnidad() {
		return CantidadUnidad;
	}

	/**
	 * @param cantidadUnidad the cantidadUnidad to set
	 */
	public void setCantidadUnidad(String cantidadUnidad) {
		CantidadUnidad = cantidadUnidad;
	}

	/**
	 * @return the precioUnidad
	 */
	public double getPrecioUnidad() {
		return PrecioUnidad;
	}

	/**
	 * @param precioUnidad the precioUnidad to set
	 */
	public void setPrecioUnidad(double precioUnidad) {
		PrecioUnidad = precioUnidad;
	}

	/**
	 * @return the unidadesExistentes
	 */
	public int getUnidadesExistentes() {
		return UnidadesExistentes;
	}

	/**
	 * @param unidadesExistentes the unidadesExistentes to set
	 */
	public void setUnidadesExistentes(int unidadesExistentes) {
		UnidadesExistentes = unidadesExistentes;
	}

	/**
	 * @return the unidadesPedido
	 */
	public int getUnidadesPedido() {
		return UnidadesPedido;
	}

	/**
	 * @param unidadesPedido the unidadesPedido to set
	 */
	public void setUnidadesPedido(int unidadesPedido) {
		UnidadesPedido = unidadesPedido;
	}

	/**
	 * @return the nivelNuevoPedido
	 */
	public int getNivelNuevoPedido() {
		return NivelNuevoPedido;
	}

	/**
	 * @param nivelNuevoPedido the nivelNuevoPedido to set
	 */
	public void setNivelNuevoPedido(int nivelNuevoPedido) {
		NivelNuevoPedido = nivelNuevoPedido;
	}

	/**
	 * @return the suspendido
	 */
	public int getSuspendido() {
		return Suspendido;
	}

	/**
	 * @param suspendido the suspendido to set
	 */
	public void setSuspendido(int suspendido) {
		Suspendido = suspendido;
	}

	@Override
	public String toString() {
		return "Productos [IdProducto=" + IdProducto + ", NombreProducto=" + NombreProducto + ", IdProveedor="
				+ IdProveedor + ", IdCategoria=" + IdCategoria + ", CantidadUnidad=" + CantidadUnidad
				+ ", PrecioUnidad=" + PrecioUnidad + ", UnidadesExistentes=" + UnidadesExistentes + ", UnidadesPedido="
				+ UnidadesPedido + ", NivelNuevoPedido=" + NivelNuevoPedido + ", Suspendido=" + Suspendido + "]";
	}

}
