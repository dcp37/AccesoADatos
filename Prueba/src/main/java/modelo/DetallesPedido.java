/**
 * 
 */
package modelo;

/**
 * @author David♥
 *
 */
public class DetallesPedido {
	private int IdPedido;
	private int IdProducto;
	private double PrecioUnidad;
	private int Cantidad;
	private double Descuento;

	/**
	 * @param idPedido
	 * @param idProducto
	 * @param precioUnidad
	 * @param cantidad
	 * @param descuento
	 */
	public DetallesPedido(int idPedido, int idProducto, double precioUnidad, int cantidad, double descuento) {
		IdPedido = idPedido;
		IdProducto = idProducto;
		PrecioUnidad = precioUnidad;
		Cantidad = cantidad;
		Descuento = descuento;
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
	 * @return the cantidad
	 */
	public int getCantidad() {
		return Cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return Descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(double descuento) {
		Descuento = descuento;
	}

	@Override
	public String toString() {
		return "DetallesPedido [IdPedido=" + IdPedido + ", IdProducto=" + IdProducto + ", PrecioUnidad=" + PrecioUnidad
				+ ", Cantidad=" + Cantidad + ", Descuento=" + Descuento + "]";
	}

}
