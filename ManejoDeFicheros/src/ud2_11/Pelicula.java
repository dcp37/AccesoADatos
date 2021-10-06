/**
 * Hola
 */
package ud2_11;

/**
 * @author ♥David♥
 *
 */
public class Pelicula {
	private int id;
	private String titulo;
	private int anho;
	private String sinopsis;

	/**
	 * @param id
	 * @param titulo
	 * @param anho
	 * @param sinopsis
	 */
	public Pelicula(int id, String titulo, int anho, String sinopsis) {
		this.id = id;
		this.titulo = titulo;
		this.anho = anho;
		this.sinopsis = sinopsis;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", anho=" + anho + ", sinopsis=" + sinopsis + "]";
	}

}
