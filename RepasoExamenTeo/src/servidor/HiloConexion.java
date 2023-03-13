package servidor;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HiloConexion implements Runnable{

	Socket sock;
	
	public HiloConexion(Socket sock) {
		this.sock = sock;
	}

	public void run() {
		try {
			// PASO 2 RECIBIMOS LOS DATOS
			// COGEMOS DATOS
			DataInputStream entradaDatos = new DataInputStream(sock.getInputStream());		//hacemos la entrada de datos y le pasamos el sock con getinput...
			String texto = entradaDatos.readUTF();											// ponemos en un string los datos que leemos
			entradaDatos.close();															// y cerramos la entrada de datos
			System.out.println("Texto recibido: "+texto);
			System.out.println("IP del cliente: "+sock.getRemoteSocketAddress());
			
			// PASO 3 ESPERAMOS 2 SEG
			Thread.sleep(2000);			//si esto no funciona 
			
			// PASO 4 CREAMOS EL HASH CON LOS DATOS
			MessageDigest hashCreator = MessageDigest.getInstance("SHA-256");				//en este tipo de clases solo hay que instanciarlos no hace falta crear un nuevo objeto (new tatata)
			hashCreator.update(texto.getBytes());                                           //con esto estoy cargando los datos en texto
			byte[] hash = hashCreator.digest();												//con esto metemos la cadena en el array de bytes
			String textoHash = "";
			for (byte b : hash) {
				textoHash+=Integer.toHexString(b & 0xFF);
			}
			System.out.println(textoHash);
			
			// PASO 5 ESCRIBIMOS EL HASH Y LO MANDAMOS
			DataOutputStream salidaDatos = new DataOutputStream(sock.getOutputStream());
			salidaDatos.writeUTF(textoHash);
			salidaDatos.close();
			sock.close();
			
			
		} catch (IOException e) {
			System.err.println("Error con el socket o recibiendo/enviando datos");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Error con el creador de hashes");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("Error en el sleep");
			e.printStackTrace();
		}
	}

}
