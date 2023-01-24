package clientFTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class SubirArchivo {
	public static void main(String[] args) throws SocketException, IOException {
		
		FTPClient cliente = new FTPClient();
		cliente.connect("127.0.0.1");
		
		boolean conectado = cliente.login("user", "password");
		// Para establecer modo pasivo (depende de la configuracion del servidor)
		// cliente.enterLocalPassiveMode();
		
		// Le decimos el tipo de fichero que vamos a subir,todo lo que no sea txt es binario
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		if(conectado) {
			System.out.println("!login correcto¡");
			File archivoSubida = new File("./Archivos/UD2_Manejo_de_Ficheros.pdf");
			FileInputStream is = new FileInputStream(archivoSubida);
			OutputStream os = cliente.storeFileStream("socketsEnJava2.pdf");
			
			// preparar el buffer
			byte[] buffer = new byte [4096];
			int bytesLeidos = 0;
			
			// hacer un bucle para enviar los bytes del archivo
			while((bytesLeidos = is.read(buffer)) != -1) {
				os.write(buffer, 0 , bytesLeidos);
			}
			is.close();
			os.close();
							// si el comando se ha ejecutado...(completePendingCommand)
			if(cliente.completePendingCommand()) {
				System.out.println("Archivos subido correctamente.");
			}
			else {
				System.err.println("Error!");
			}
		}
		else {
			System.err.println("Error en el login.");
		}
		cliente.disconnect();
	}
}
