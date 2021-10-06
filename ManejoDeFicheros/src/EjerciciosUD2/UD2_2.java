package EjerciciosUD2;

import java.io.File;

public class UD2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			System.out.println("Introduce una ruta de directorio");
			System.exit(-1);
		} else {
			File f = new File(args[0]);
			File[] archivos = f.listFiles();
			for (File file : archivos) {
				if (file.exists()) {
					System.out.println("Nombre del archivo: " + file.getName());
				} else {
					System.out.println("Este directorio o fichero no existe. ");
				}
			}
		}
	}
}
