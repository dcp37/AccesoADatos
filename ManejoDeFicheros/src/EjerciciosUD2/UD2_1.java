package EjerciciosUD2;

import java.io.File;

public class UD2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\WINDOWS");
		// obtenci�n del contenido de un directorio
		File[] archivos = f.listFiles();
		// almacenamiento de los elementos(directorios, ficheros)
		for (File file : archivos) {
			if (file.isFile() && file.isHidden()) {
				// comprobaci�n de si es un archivo y si est� oculto
				System.out.println("Nombre del archivo: " + file.getName());
				System.out.println("Ubicación: " + file.getAbsolutePath());
				System.out.println("¿Está oculto? " + file.isHidden());
				System.out.println("Tamaño en bytes: " + file.length());
				System.out.println("¿Se puede leer? " + file.canRead());
				System.out.println("¿Se puede escribir? " + file.canWrite());
			}
		}
	}

}
