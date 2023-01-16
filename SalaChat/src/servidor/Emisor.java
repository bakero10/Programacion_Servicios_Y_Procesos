package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

	public class Emisor extends Thread {
		
		private Socket sock;																			
		private ArrayList<Mensaje> listaMensajes;
		private boolean emisorFinalizado;
		public void finalizar() {
			emisorFinalizado = true;
	}
	public Emisor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
	}
	@Override
	public void run() {
		// Inicializar la salida. object output stream (el canal de salida que usamos para mandar el mensaje)
		ObjectOutputStream salida = null;					
		try {
			salida = new ObjectOutputStream(sock.getOutputStream());	// La salida de datos la mandamos por el socket
		} catch (Exception e) {
			// TODO: handle exception
		}
		//while true
		while(!emisorFinalizado) {										// Mientras no sea verdadeo
			Mensaje m = null;											
																		
			synchronized (listaMensajes) {								// esperar notificación (synchronizadamente)
				try {
					listaMensajes.wait();								// listaMensajes se pone en espera
				} catch (InterruptedException e) {
					System.out.println("Error en el [emisor](me han interrumpido mientras esperaba)");
					e.printStackTrace();
				}
				m = listaMensajes.get(listaMensajes.size() -1);
			}
			// enviarlo por la salida.
			try {
				salida.writeObject(m);
			} catch (IOException e) {
				System.out.println("Error en el [emisor](error al enviar el mensaje)");
				finalizar();
				e.printStackTrace();
			}
		}
		try {
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
}
