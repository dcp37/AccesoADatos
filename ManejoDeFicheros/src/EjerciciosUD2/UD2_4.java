package EjerciciosUD2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UD2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("pares.txt"));
			for (int i = 0; i < 501; i = i + 2) {
				//gracias jaime por i+2
				String linea = String.valueOf(i);

				bw.write(linea);

				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("pares.txt"));
			String pares;
			while ((pares = br.readLine()) != null) {
				System.out.println(pares);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
