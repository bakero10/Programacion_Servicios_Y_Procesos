package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {

	public static void main(String[] args) throws IOException {

		//hay que pasarle un puerto y la direccion ip del servidor puerto=3001 y la ip es Inet....
		DatagramSocket dsock = new DatagramSocket(3001,InetAddress.getByName("localhost"));	
		
		// El servidor envia informacion
		// Clase datagram packet rellena con la info del cliente.
		
		String mensaje = "Hola mundo";
		// los datos de la conexion son refereidos al receptor
		//en este caso coinciden.
		//1 er parametro --> convierto mensaje a bytes.
		//2 do parametro --> la longitud del mensaje.
		//3 er parametro --> Direccion ip al que le envio (en este caso a nosotros mismos localhost)
		// 4 to parametro --> Puerto por el que enviamos
		DatagramPacket info = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length,InetAddress.getByName("192.168.101.255"), 3000);
		
		dsock.send(info);
		
		
	}
	
}
