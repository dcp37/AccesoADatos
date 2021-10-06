package EjerciciosUD2;

import java.io.File;
import java.io.IOException;

public class UD2_3 {
	public static void creaDirectorio(File f) {
		if (f.exists()) {
			System.out.println("El directorio ya existe");
			creaFichero(f);
		} else {
			f.mkdir();
			System.out.println("Se ha creado el directorio: " + f.getPath());
		}
	}

	public static void creaFichero(File f) {
		f = new File(f + "\\fichero.txt");
		try {
			if (!f.exists()) {
				f.createNewFile();
				System.out.println("Fichero creado");
			} else {
				System.out.println("No se ha podido crear el fichero");
				eliminaFichero(f);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void eliminaFichero(File f) {
		if (f.delete()) {
			System.out.println("Se ha eliminado el fichero");
		}
	}

	public static void main(String[] args) {
		File f = new File("C:\\Users\\usuario\\DAM2");
		// TODO Auto-generated method stub
		creaDirectorio(f);
	}
}
