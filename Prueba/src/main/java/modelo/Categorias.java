/**
 * 
 */
package modelo;

import java.sql.Blob;

/**
 * @author David♥
 *
 */
public class Categorias {
	private int idCategoria;
	private String NombreCategoria;
	private String Descripcion;
	private Blob Imagen;

	/**
	 * @param idCategoria
	 * @param nombreCategoria
	 * @param descripcion
	 * @param imagen
	 */
	public Categorias(int idCategoria, String nombreCategoria, String descripcion, Blob imagen) {
		this.idCategoria = idCategoria;
		NombreCategoria = nombreCategoria;
		Descripcion = descripcion;
		Imagen = imagen;
	}

	/**
	 * @return the idCategoria
	 */
	public int getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	/**
	 * @return the nombreCategoria
	 */
	public String getNombreCategoria() {
		return NombreCategoria;
	}

	/**
	 * @param nombreCategoria the nombreCategoria to set
	 */
	public void setNombreCategoria(String nombreCategoria) {
		NombreCategoria = nombreCategoria;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return Descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	/**
	 * @return the imagen
	 */
	public Blob getImagen() {
		return Imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(Blob imagen) {
		Imagen = imagen;
	}

	@Override
	public String toString() {
		return "Categorias [idCategoria=" + idCategoria + ", NombreCategoria=" + NombreCategoria + ", Descripcion="
				+ Descripcion + ", Imagen=" + Imagen + "]";
	}

}
