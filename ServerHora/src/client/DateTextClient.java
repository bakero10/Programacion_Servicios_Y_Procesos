package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class DateTextClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
	/*	
		Socket sock = new Socket("localhost",server.DateTextServer.PORT);		//localhost si queremos conectarnos con nosotros mismos
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		
		String fecha = entrada.readUTF();
		
		System.out.println(fecha);
		entrada.close();
		sock.close();
		*/
		
		//Preparo el socket
		Socket sock = new Socket();
		//Preparo la direccion del servidor.IP y puerto
		SocketAddress sockAddr = new InetSocketAddress("localhost",server.DateTextServer.PORT);
		//Intento la conexion,estableciendo un timeout de 6 segundos
		sock.connect(sockAddr,6000);
		
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		String fecha = entrada.readUTF();
		System.out.println(fecha);
		entrada.close();
		sock.close();
	}
	
}
