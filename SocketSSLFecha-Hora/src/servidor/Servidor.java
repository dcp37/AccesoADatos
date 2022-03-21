/**
 * 
 */
package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocketFactory;

/**
 * @author David♥
 *
 */
public class Servidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Hola Soy el Servidor:)");

			System.setProperty("javax.net.ssl.keyStore", "certs/almacenServidor.p12");
			System.setProperty("javax.net.ssl.keyStorePassword", "123456");
			System.setProperty("javax.net.ssl.trustStore", "certs/almacenServidor.p12");
			System.setProperty("javax.net.ssl.trustStorePassword", "123456");
			SSLServerSocketFactory sslFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			ServerSocket servSock = sslFactory.createServerSocket(5555);
			Socket socket = servSock.accept();
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			// System.out.println("Hola Soy el Servidor:)");
			while (true) {
				System.out.println(entrada.readUTF());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
