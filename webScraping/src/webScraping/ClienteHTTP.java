package webScraping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClienteHTTP {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// CONEXION
		HttpClient cliente = HttpClient.newHttpClient();
		
		// LA URL QUE QUEREMOS
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://www.w3schools.com/xml/ajax_intro.asp"))
				.GET()
				.build();
		
		// RESPUESTA --> Recibo la respuesta como string
		HttpResponse<String> res = cliente.send(req,HttpResponse.BodyHandlers.ofString());
		// Recibo la respuesta como fichero descargado
		//HttpResponse<Path> resPath = cliente.send(req, HttpResponse.BodyHandlers.ofFile(Paths.get("descargado.html")));
		// Recibir la respuesta mediante un stream
		//HttpResponse<InputStream> resInputStream = cliente.send(req, HttpResponse.BodyHandlers.ofInputStream());
		
		Document doc = Jsoup.parse(res.body());
					// si ponemos inspeccionar y copiar (copy selector) y lo introducimos en el doc.select nos imprimira los datos que queramos
					// si lo separamos por una coma nos dara los datos que queramos concatenados
		
		Elements elementos = doc.select("#demo > button");
		
		for (Element e : elementos) {
			System.out.println(e.text());
		}
		
		System.out.println(res);
		System.out.println("--------------------------------");
		//System.out.println(res.body());
	}
}
