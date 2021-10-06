package ud2_10;

import java.util.ArrayList;
import java.util.List;

public class listaPelicula {
	private List<Pelicula> listaPelis = new ArrayList<Pelicula>();

	public listaPelicula() {
	}

	public void add(Pelicula p) {
		listaPelis.add(p);
	}

	public List<Pelicula> getListaPelis() {
		return listaPelis;
	}

}
