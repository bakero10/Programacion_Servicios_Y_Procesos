package webScraping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;

public class ClienteHTTP {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// CONEXION
		HttpClient cliente = HttpClient.newHttpClient();
		
		// LA URL QUE QUEREMOS
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://www.meteoclimatic.net/?screen_width=1440"))
				.GET()
				.build();
		
		// RESPUESTA
		HttpResponse res = cliente.send(req,HttpResponse.BodyHandlers.ofString());
		
		System.out.println(res);
		System.out.println(res.body());
	}
}
