package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTextServer {
	
	public static final int PORT = 3001;
			
	public static void main(String[] args) throws IOException {
		
		ServerSocket servSock = new ServerSocket(PORT);
		
		Socket sock = servSock.accept();
		
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		Date fecha =  new Date();
		dos.writeUTF(fecha.toString());
		dos.close();
		sock.close();
		servSock.close();
	}
}