/**
 * 
 */
package ud2_11;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

/**
 * @author David♥
 *
 */
public class Videoclub {

	public static void escribePelicula(List<Pelicula> lista) {
		try {
			FileWriter fw = new FileWriter("Videoclub.json");
			new Gson().toJson(lista, fw);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void leePeliculas() {
		Gson gson = new Gson();
		try {
			String fichero = new String(Files.readAllBytes(Paths.get("Videoclub.json")));
			List<Pelicula> lista = Arrays.asList(gson.fromJson(fichero, Pelicula[].class));
			for (Pelicula pelicula : lista) {
				System.out.println(pelicula);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pelicula> lista = Arrays.asList(
				new Pelicula(1, "El Señor de los Anillos: La Comunidad del Anillo", 2001, ""),
				new Pelicula(2, "El Señor de los Anillos: Las dos Torres", 2002, ""),
				new Pelicula(3, "El Señor de los Anillos: El retorno del Rey", 2004, ""));
		escribePelicula(lista);
		leePeliculas();
	}

}
