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
		Scanner s = new Scanner(System.in);
		
		//PASO 1 CREAMOS EL PUENTE Y MANDAMOS EL MENSAJE
		String textoIntroducido = s.nextLine();
		Socket sock = new Socket("localhost",4321);    										 // CREAMOS EL TUNEL Y LE PASAMOS LA IP Y EL PUERTO
		DataOutputStream salidaDatos = new DataOutputStream(sock.getOutputStream());		//CREAMOS LA SALIDA DE DATOS
		salidaDatos.writeUTF(textoIntroducido);												//ESCRIBIMOS EL STRING EN LA SALIDA
		salidaDatos.close();																//CERRAMOS LA SALIDA
		
		//PASO 6 RECIBIMOS LOS DATOS DEL SERVIDOR
		DataInputStream entradaDatos = new DataInputStream(sock.getInputStream());			//CREAMOS ENTRADA DE DATOS
		String hashRecibido = entradaDatos.readUTF();										//LO ESCRIBIMOS EN EL STRING
		
		//PASO 7 CREAMOS EL HASH CON LOS DATOS RECIBIDOS 
		MessageDigest hashCreator = MessageDigest.getInstance("SHA-256");				//CREAMOS EL HASH
		hashCreator.update(textoIntroducido.getBytes());                                //CARGAMOS EN EL HASH EL TEXTO INTRODUCIDO EN BYTES
		byte[] hash = hashCreator.digest();												//METEMOS EN EL ARRAY DE BYTES EL HASH CREADO
		String textoHash = "";															//INICIALIZAMOS EL STRING
		for (byte b : hash) {															//RECORREMOS EL ARRAY DE BYTES
			textoHash+=Integer.toHexString(b & 0xFF);									//INTRODUCIMOS EN EL STRING BYTE BYTE
		}
		// PASO 8 COMPROBACION DE SI LOS HASHES SON IGUALES
		System.out.println("Hash calculado: "+textoHash);
		System.out.println("Hash Recibido: "+hashRecibido);
		if(textoHash.equals(hashRecibido)) {											//SI LOS HASHES SON IGUALES
			System.out.println("Los hashes son iguales");
		}
		else {
			System.out.println("Los hashes no coinciden");
		}
		
		
		
	}
}
