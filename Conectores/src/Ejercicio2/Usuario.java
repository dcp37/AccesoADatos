/**
 * 
 */
package Ejercicio2;

/**
 * @author David♥
 *
 */
public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private String paisUsuario;

	/**
	 * @param idUsuario
	 * @param nombreUsuario
	 * @param paisUsuario
	 */
	public Usuario(int idUsuario, String nombreUsuario, String paisUsuario) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.paisUsuario = paisUsuario;
	}

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the paisUsuario
	 */
	public String getPaisUsuario() {
		return paisUsuario;
	}

	/**
	 * @param paisUsuario the paisUsuario to set
	 */
	public void setPaisUsuario(String paisUsuario) {
		this.paisUsuario = paisUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", paisUsuario=" + paisUsuario
				+ "]";
	}

}
