package ud2_10;

//♥David♥
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class EscribePelis {

	public static void escrituraXML(listaPelicula lp) {

		XStream xs = new XStream(new DomDriver("UTF-8"));
		xs.alias("PelÃ­cula", Pelicula.class);
		xs.alias("peliculas", listaPelicula.class);
		xs.addImplicitCollection(listaPelicula.class, "listaPelis");
		try {
			xs.toXML(lp, new FileOutputStream("Videoclub.xml"));
		} catch (FileNotFoundException e) {
			System.out.println(
					"â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥Fichero no encontradoâ™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥â™¥");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Se ha creado el fichero XML");
	}

	public static void lecturaXML() {
		XStream xs = new XStream();
		xs.alias("peliculas", listaPelicula.class);
		xs.alias("PelÃ­cula", Pelicula.class);
		xs.addImplicitArray(listaPelicula.class, "listaPelis");

		// listaPelicula lp = new
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listaPelicula lp = new listaPelicula();
		Pelicula p1 = new Pelicula(1, "El SeÃ±or de los Anillos: La Comunidad del Anillo", 2001,
				"Ambientada en la Tierra Media, cuenta la historia del SeÃ±or Oscuro Sauron, que estÃ¡ buscando el Anillo Ãšnico, el cual ha acabado en poder del hobbit Frodo BolsÃ³n (Elijah Wood). El destino de la Tierra Media estÃ¡ en juego mientras Frodo y ocho compaÃ±eros que forman la CompaÃ±Ã­a del Anillo comienzan un largo y peligoso viaje hacia el Monte del Destino en la tierra de Mordor, que es el Ãºnico lugar en el que el anillo puede ser destruido");
		Pelicula p2 = new Pelicula(2, "El SeÃ±or de los Anillos: Las dos Torres", 2002,
				"La trama de la pelÃ­cula comienza tras la disoluciÃ³n de la CompaÃ±Ã­a del Anillo. Boromir ha muerto a manos del jefe de los uruk-hai, Lurtz, en un intento de salvar a los hobbits Meriadoc Brandigamo y Peregrin Tuk, que acaban siendo capturados. Frodo BolsÃ³n y Sam Gamyi parten solos hacia Mordor para destruir el Anillo Ãšnico en el Monte del Destino, mientras que Aragorn, Gimli y LÃ©golas persiguen a los uruks con el fin de liberar a sus amigos capturados.");
		Pelicula p3 = new Pelicula(3, "El SeÃ±or de los Anillos: El retorno del Rey", 2003,
				"Trata sobre la Ãºltima parte del viaje que emprendieron los nueve compaÃ±eros (de los cuales quedan solamente ocho) para salvar a la Tierra Media de la oscuridad impuesta por Sauron. En esta parte se decide el destino de todos los habitantes de estas tierras.");
		lp.add(p1);
		lp.add(p2);
		lp.add(p3);
		escrituraXML(lp);
		//

	}
}
