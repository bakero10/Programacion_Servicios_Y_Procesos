package clientFTP;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class BajarArchivo {
	public static void main(String[] args) throws SocketException, IOException {
		
		FTPClient cliente = new FTPClient();
		cliente.connect("192.168.101.100");
		
		boolean conectado = cliente.login("user", "password");
		
		if(conectado) {
			System.out.println("!login correcto¡");
			cliente.setFileType(FTP.BINARY_FILE_TYPE);
			File archivoLocal = new File("./fichero.txt");
			//con retrieveFile
			BufferedOutputStream streamLocal = new BufferedOutputStream(new FileOutputStream(archivoLocal));
			if(cliente.retrieveFile("/carpeta/bb.txt", streamLocal)) {
				System.out.println("¡Fichero descargado!");				
			}
			else {
				System.err.println("Error en el login");
			}
			cliente.disconnect();
			
		}
		
		
		else {
			System.err.println("Error en el login.");
		}
		cliente.disconnect();
	}
}
