package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class DateTextClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket sock = new Socket("localhost",server.DateTextServer.PORT);		//localhost si queremos conectarnos con nosotros mismos
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		
		String fecha = entrada.readUTF();
		
		System.out.println(fecha);
		entrada.close();
		sock.close();
	}
	
}
