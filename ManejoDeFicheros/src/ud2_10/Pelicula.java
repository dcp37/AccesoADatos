package ud2_10;

public class Pelicula {
	private int id;
	private String titulo;
	private int anho;
	private String sinopsis;

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
