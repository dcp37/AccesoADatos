/**
 * 
 */
package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.net.ssl.SSLSocketFactory;

/**
 * @author David♥
 *
 */
public class Cliente {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub

		// almacen del certificado de cliente
		System.setProperty("javax.net.ssl.keyStore", "certs/almacenCliente.p12");
		// contraseña del almacen del certificado del cliente
		System.setProperty("javax.net.ssl.keyStorePassword", "123456");
		// almacen de certificados en que confío (en este caso tengo el mismo almacen
		// para
		// el certificado propio y el certificado de los sitios en que confio)
		System.setProperty("javax.net.ssl.trustStore", "certs/almacenCliente.p12");
		// contraseña del almacen de los certificados en que confío
		System.setProperty("javax.net.ssl.trustStorePassword", "123456");
		SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		Socket socket;
		try {
			socket = sslFactory.createSocket("192.168.102.5", 5555);// localhost
			System.out.println("Yo soy el cliente");
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			Scanner teclado = new Scanner(System.in);
			while (true) {
				salida.writeUTF(teclado.nextLine());
				/*
				 * 
				 */
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				String mensaje = teclado.nextLine();
				md.update(mensaje.getBytes());
				byte[] hash = md.digest();

				// Se escribe byte a byte en hexadecimal
				for (byte b : hash) {
					System.out.print(Integer.toHexString(0xFF & b));
				}
				System.out.println();
				/*
				 * 
				 */

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
