/**
 * 
 */
package EjerciciosUD2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @author ♥David♥
 *
 */
public class UD2_9 {

	public static void leeProfesor(int num) throws IOException {
		File f = new File("ProfesSierraDeGuara.dat");
		RandomAccessFile raf = new RandomAccessFile(f, "r");
		int id = num;
		int posicion = (id - 1) * 56;
		if (posicion > raf.length() - 56) {
			System.out.println("No existe el empleado buscado");
			System.exit(-1);
		}
		int departamento;
		double antiguedad;
		char profes[] = new char[20];
		System.out.println("--------------------------");
		raf.seek(posicion);
		int id_pos = raf.readInt();
		for (int i = 0; i < profes.length; i++) {
			profes[i] = raf.readChar();
		}
		String profesor = new String(profes);
		departamento = raf.readInt();
		antiguedad = raf.readInt();
		System.out.println(id_pos + " " + profesor + " " + departamento + "         " + antiguedad);
		raf.close();
	}

	public static void escribeProfesor() throws IOException {
		File f = new File("ProfesSierraDeGuara.dat");
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		int id[] = { 1, 2, 3, 4 };
		String[] profesor = { "Alberto", "Luis", "Belén", "Leticia" };
		int departamento[] = { 10, 20, 30, 40 };
		double antiguedad[] = { 29.5, 2.2, 2.18, 52.4 };
		/*
		 * int id = 4bytes nombres 20 caracteres = 40 bytes departamento int = 4 bytes
		 * Antigüedad real = 8 bytes Total = 4+40+4+8=56bytes
		 */

		StringBuffer sb = null;
		int total = profesor.length;

		for (int i = 0; i < total; i++) {
			raf.writeInt(id[i]);
			sb = new StringBuffer(profesor[i]);
			sb.setLength(20);
			raf.writeChars(sb.toString());
			raf.writeInt(departamento[i]);
			raf.writeDouble(antiguedad[i]);
		}
		raf.close();
	}

	public static void eliminaProfesor(int i) throws IOException {
		File f = new File("ProfesSierraDeGuara.dat");
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		int id = i;
		int posicion = (id - 1) * 53;
		if (posicion > raf.length() - 53) {
			System.out.println("No existe el empleado buscado");
			System.exit(-1);
		}
		char profes[] = new char[20];
		System.out.println("--------------------------");
		raf.seek(posicion);
		int id_pos = raf.readInt();
		raf.writeInt(0);
		for (int j = 0; j < profes.length; j++) {
			profes[j] = raf.readChar();
		}
		String profesor = new String(profes);
		System.out.println(id_pos + " " + profesor + ": Ha sido eliminadX");
		raf.close();
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int id = s.nextInt();
		s.close();

		escribeProfesor();
		eliminaProfesor(id);
		for (int i = 1; i < 20; i++) {
			leeProfesor(i);
		}
	}

}
