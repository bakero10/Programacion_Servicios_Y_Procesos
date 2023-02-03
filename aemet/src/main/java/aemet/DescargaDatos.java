package aemet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DescargaDatos {
	public static void main(String[] args) throws IOException, InterruptedException {
		String server = "https://opendata.aemet.es/opendata";
		String apikey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMTAxNjJAaWVzc2llcnJhZGVndWFyYS5jb20iLCJqdGkiOiIyNWVmYTRiYi00OWYzLTRkYWEtYTAwNS01ZDAzN2Q2OGIyZDkiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3NTE1NDYxMiwidXNlcklkIjoiMjVlZmE0YmItNDlmMy00ZGFhLWEwMDUtNWQwMzdkNjhiMmQ5Iiwicm9sZSI6IiJ9.EBa9x1juCZfg4hR5ce_IJZXLgpnuSx5LvVSXywzwFio";
		String endpoint = "/api/observacion/convencional/todas";

		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create(server + endpoint + "?api_key=" + apikey))
				.GET()
				.build();

		HttpResponse<String> res = cliente.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(res.body());
		System.out.println(res);
		
		//https://opendata.aemet.es/opendata/api/observacion/convencional/todas?
		//usar jackson para obtener la cadena de datos y de metadatos
		ObjectMapper mapper = new ObjectMapper();
		String urlDatos = mapper.readTree(res.body()).at("/datos").asText();
		//hacer las peticiones correspondientes de esos dos JSON
		HttpRequest reqDatos = HttpRequest.newBuilder()
				.uri(URI.create(urlDatos))
				.GET()
				.build();
		
		HttpResponse<String> resDatos = cliente.send(reqDatos, HttpResponse.BodyHandlers.ofString());
		//Mapeamos los datos en una lista.
		List<EstacionMeteo> listaEstaciones = mapper.readValue(resDatos.body(),
											  new TypeReference<List<EstacionMeteo>>() {});
		
		System.out.println(listaEstaciones.get(0).getUbi());
		System.out.println(listaEstaciones.get(0).getTa());
		//coger el valor deseado filtrando por el idema de Huesca (9901X)
	}
}
