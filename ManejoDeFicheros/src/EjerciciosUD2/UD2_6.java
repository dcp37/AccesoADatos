package EjerciciosUD2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UD2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int contador = 0;
		try {
			BufferedReader fr = new BufferedReader(new FileReader("Quijote.txt"));
			String linea;
			System.out.println("introduce la palabra a buscar");
			String palabra = s.next();
			s.close();
			while ((linea = fr.readLine()) != null) {
				if (linea.contains(palabra.toLowerCase())) {
					contador++;
				}

				System.out.println(linea);
			}
			System.out.println(palabra + " " + contador + " veces");
			System.out.println(palabra);
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
