
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
//		Creo un socket especificando la dirección con la que quiero conectar IP:Puerto
		Socket sock = new Socket("192.168.101.5", 2600);

//		Cuando el constructor vuelve es que ya he conectado.
		System.out.println("[Cliente]: Yo soy " + sock.getLocalAddress()); // obtenemos la dirección local
		System.out.println("[Cliente]: Yo estoy en el puerto " + sock.getLocalPort()); // obtenemos el puerto local

		System.out.println("[Cliente]: Yo estoy conectado con " + sock.getInetAddress()); // direccion remota (quien me
																							// ha conectado)
		System.out.println("[Cliente]: Yo estoy conectado con el puerto " + sock.getPort()); // recogemos el puerto al

//		Creo y lanzo un hilo de teclado, que se encargará de leer del teclado y enviar por el socket sock.																						
		HiloTeclado ht = new HiloTeclado(sock);
		ht.start();

//		cojo la entrada del socket para empezar a leer
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
//		Leo el primer mensaje
		String mensaje = entrada.readUTF();

		// Bucle principal, minetras el mensaje no sea Q sigo leyendo e imprimiendo por
		// pantalla.
		while (!mensaje.equals("Q")) {
			System.out.println(mensaje);
			mensaje = entrada.readUTF();
		}

//		En cuanto el mensaje es Q, salgo del bucle y cierro el socket y entrada.
		entrada.close();
		sock.close();

	}

}
