import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HiloTeclado extends Thread {

	Socket sock;

	public HiloTeclado(Socket sock) {
		super();
		this.sock = sock;
	}

	@Override
	public void run() {
//		Creo el teclado
		Scanner teclado = new Scanner(System.in);
		DataOutputStream salida = null;
		try {
			salida = new DataOutputStream(sock.getOutputStream());
			String mensaje = teclado.nextLine();

			while (!mensaje.equals("Q")) {
				salida.writeUTF(mensaje);
				mensaje = teclado.nextLine();
			}

			System.out.println("Recibido mensaje de salida");
			salida.close();
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
