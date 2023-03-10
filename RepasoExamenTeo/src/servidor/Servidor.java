package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//EL SEREVIDOR LO QUE HACE ES ESPERAR CONEXIONES NUEVAS Y LANZARLAS
public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket servSock = new ServerSocket(4321); // lo primero que hay que hacer y le pasamos el puerto
		Socket sock = null;
		while(true) {
			sock = servSock.accept();				// tenemos que aceptar y ponernos a la espera
			new Thread(new HiloConexion(sock)).start();					//a continuacion tenemos que lanzar el hilo
		}
	}
}
