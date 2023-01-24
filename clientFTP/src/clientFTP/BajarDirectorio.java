package clientFTP;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class BajarDirectorio {
	public static void main(String[] args) throws SocketException, IOException {
		
			FTPClient cliente = new FTPClient();
			cliente.connect("192.168.101.100");
			
			boolean conectado = cliente.login("user", "password");
			if(conectado) {
				System.out.println("¡login correcto!");
				cliente.setFileType(FTP.FILE_STRUCTURE);
				File archivo = new File("./ftp_directorio/nuevaC");
				
			}
			else {
				System.err.println("¡Error en el login!");
			}
			cliente.disconnect();
}
	
}
