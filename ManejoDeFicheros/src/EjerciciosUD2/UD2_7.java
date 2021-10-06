package EjerciciosUD2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UD2_7 {
	public static void lecturaNumeros() throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream("puntuacion.dat"));
		try {
			while (true) {
				System.out.println(dis.readDouble());
			}
		} catch (EOFException e) {
			// TODO: handle exception

		}
		dis.close();
	}

	public static void escrituraNumeros() {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("puntuacion.dat"));

			for (int i = 0; i <= 20; i++) {
				double valorDado = Math.floor(Math.random() * 5 + 1);
				dos.writeDouble(valorDado);
			}

			dos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// escrituraNumeros();
		lecturaNumeros();
	}

}
