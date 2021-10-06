package EjerciciosUD2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class UD2_8 extends ObjectOutputStream {
	public UD2_8(OutputStream arg0) throws IOException {
		super(arg0);
	}

	protected void writeStreamHeader() throws IOException {
	}

	public static boolean EscribeProfesor(Profesor p) throws IOException {
		File f = new File("antiguedad.dat_obj.dat");
		if (!f.exists()) {// si NO existe el fichero

			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oop = new ObjectOutputStream(fos);
			oop.writeObject(p);
			oop.close();
		} else {
			try {
				FileOutputStream fos = new FileOutputStream(f, true);
				UD2_8 ep = new UD2_8(fos);
				ep.writeObject(p);
				ep.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

	public static void LeeProfesor() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("antiguedad.dat_obj.dat"));
		try {
			while (true) {
				System.out.println(ois.readObject());
			}
		} catch (EOFException e) {
			// TODO: handle exception
			System.out.println(" - Fin de fichero");
		}
		ois.close();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//
		System.out.println("Introduce un nombre para un profesor: ");

		String profeNomb = "";
		int profAntiguedad = 0;
		Scanner s = new Scanner(System.in);
		profeNomb = s.next();
		System.out.println("Introduce una edad para el profesor: ");
		profAntiguedad = s.nextInt();
		s.close();
		Profesor p = new Profesor(profeNomb, profAntiguedad);
		EscribeProfesor(p);
		LeeProfesor();

	}
}