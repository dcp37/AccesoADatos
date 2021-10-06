package EjerciciosUD2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UD2_5 {
	/*
	 * Pistas: - Utiliza una colecci�n (p.ej. ArrayList) donde guardar las l�neas
	 * le�das del fichero y el m�todo est�tico Collections.sort para ordenar dicha
	 * colecci�n. - Para formar el nuevo nombre de fichero puedes usar el m�todo
	 * para cadenas substring.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int l = args[0].length();

		ArrayList<String> lista = new ArrayList<String>();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("amigos.txt"));
			BufferedReader br = new BufferedReader(new FileReader("amigos.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				lista.add(linea);
				Collections.sort(lista);
			}
			for (String s : lista) {
				bw.write(s);
				bw.newLine();
			}
			bw.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
