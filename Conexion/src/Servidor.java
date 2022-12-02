import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ServerSocket servSock = new ServerSocket(2600);
		System.out.println("[Server]: Esperando...");
		Socket sock = servSock.accept();	
		System.out.println("[Server]: Conectado!");
		HiloTeclado ht = new HiloTeclado(sock);
		ht.start();
		
		System.out.println("[Server]: Yo soy " + sock.getLocalAddress());	// obtenemos la dirección local
		System.out.println("[Server]: Yo estoy en el puerto " + sock.getLocalPort());	// obtenemos el puerto local
		
		System.out.println("[Server]: Yo estoy conectado con " + sock.getInetAddress());	// direccion remota (quien me ha conectado)
		System.out.println("[Server]: Yo estoy conectado con el puerto " + sock.getPort());	// recogemos el puerto al que está conectada la dirección remota
		
		DataInputStream dis = new DataInputStream(sock.getInputStream());
		String mensaje = dis.readUTF();
		while (!mensaje.equals("Ububuebuebue")) {
			System.out.println(mensaje);
			mensaje = dis.readUTF();
		}
		System.out.println("Sesión finalizada!");
		
		dis.close();
		sock.close();
		servSock.close();
		ht.join();
	}
	
}
