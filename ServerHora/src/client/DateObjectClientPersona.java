package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import model.Persona;

public class DateObjectClientPersona {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		Socket sock = new Socket("localhost",3001);
		
		ObjectInputStream entradaObjeto = new ObjectInputStream(sock.getInputStream());
		
		Persona p = (Persona) entradaObjeto.readObject();
		
		System.out.println(p);
		
	}
}
