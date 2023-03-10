package cliente;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Cliente {
	// ultima clase que hay que preparar
	public static void main(String[] args) throws UnknownHostException, IOException, NoSuchAlgorithmException {
		Scanner teclado = new Scanner(System.in);
		
		String textoIntroducido = teclado.nextLine();
		Socket sock = new Socket("localhost",4321);
		DataOutputStream salidaDatos = new DataOutputStream(sock.getOutputStream());
		salidaDatos.writeUTF(textoIntroducido);
		salidaDatos.close();
		
		DataInputStream entradaDatos = new DataInputStream(sock.getInputStream());
		String hashRecibido = entradaDatos.readUTF();
		
		
		//ESTO LO HEMOS COPIADO DE HILO CONEXION Y HEMOS CAMBIADO TEXTO INTRODUCIDO
		MessageDigest hashCreator = MessageDigest.getInstance("SHA-256");				//en este tipo de clases solo hay que instanciarlos no hace falta crear un nuevo objeto (new tatata)
		hashCreator.update(textoIntroducido.getBytes());                                           //con esto estoy cargando los datos en texto
		byte[] hash = hashCreator.digest();												//con esto metemos la cadena en el array de bytes
		String textoHash = "";
		for (byte b : hash) {
			textoHash+=Integer.toHexString(b & 0xFF);
		}
		//IMPRIMIMOS AMBOS HASHES
		System.out.println("Hash calculado: "+textoHash);
		System.out.println("Hash Recibido: "+hashRecibido);
		//COMPROBAMOS QUE SEAN IGUALES
		if(textoHash.equals(hashRecibido)) {
			System.out.println("Los hashes son iguales");
		}
		else {
			System.out.println("Los hashes no coinciden");
		}
		
		
		
	}
}
