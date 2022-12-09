package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class HiloConexion extends Thread{

	
	Socket sock;
	
	
	
	public HiloConexion(Socket sock) {
		super();
		this.sock = sock;
	}



	public void run() {
		DataOutputStream salida = null;
		try {
			salida = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fecha = new Date();
		
		try {
			salida.writeUTF(fecha.toString());
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
