package servidor;

import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Emisor extends Thread {
	private Socket sock;
	private ArrayList<Mensaje> listaMensajes;
	public Emisor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
	}
	@Override
	public void run() {
		//Inicializar la salida. object output stream
		
		//while true
				
				// esperar notificación (synchronizadamente)
		
				// coger el último mensaje (synchronizadamente)
		
				// enviarlo por la salida.
	}
	
	
}
