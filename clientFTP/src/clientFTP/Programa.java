package clientFTP;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Programa {
	
	public static void mostrarContenidoDirectorio(FTPClient cliente, String nombreDirectorio) throws IOException {
        cliente.cwd(nombreDirectorio);
        FTPFile[] listaArchivos = cliente.listFiles();
        for (FTPFile a : listaArchivos) {
            if (a.isFile()) {
                System.out.println("[file] "+a.getName());
            }
            else {
            	System.out.println(" [dir] "+a.getName());
                mostrarContenidoDirectorio(cliente, a.getName());
                cliente.changeToParentDirectory();
            }
        }
    }
	
	public static void main(String[] args) throws SocketException, IOException {
		
		FTPClient cliente = new FTPClient();
		cliente.connect("127.0.0.1");
		
		boolean conectado = cliente.login("user", "password");
		
		if(conectado) {
			System.out.println("¡Login correcto!");
			mostrarContenidoDirectorio(cliente, "/");
		}
		else {
			
		}
		
		
	}
	

}
