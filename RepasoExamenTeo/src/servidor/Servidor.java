package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//EL SEREVIDOR LO QUE HACE ES ESPERAR CONEXIONES NUEVAS Y LANZARLAS
public class Servidor {

	public static void main(String[] args) throws IOException {
		
		ServerSocket puerto = new ServerSocket(4321); 	// ABRIMOS EL PUERTO PARA LA RECEPCION
		
		Socket tunel = null;									// CREAMOS EL TUNEL
		while(true) {										// CREAMOS UN BUCLE INFINITO PARA QUE SIEMPRE ESTE A LA ESCUCHA
			tunel = puerto.accept();						// LE DECIMOS QUE ACEPTE LAS ENTRADAS AL PUERTO
			new Thread(new HiloConexion(tunel)).start();		// CREAMOS EL HILO Y LO LANZAMOS
		}
	}
}
