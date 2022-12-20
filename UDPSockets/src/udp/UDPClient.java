package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
	
	public static void main(String[] args) throws IOException {
		

		DatagramSocket dsock = new DatagramSocket(3000,InetAddress.getByName("localhost"));	
		
		// creamos un paquete va
		byte[] arrayBytes = new byte [1000];
		// Le decimos a info que va a recibir un mensaje de 1000 bytes y la longitud
		DatagramPacket info = new DatagramPacket(arrayBytes, arrayBytes.length);
		dsock.receive(info);
		
		System.out.println("Recibido de: "+info.getAddress());
		System.out.println("Por el puerto: "+info.getPort());
		System.out.println("Datos recibidos: "+new String(info.getData()));
		
	}
}
