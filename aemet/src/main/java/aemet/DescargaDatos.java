package aemet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DescargaDatos {
	public static void main(String[] args) throws IOException, InterruptedException {
		String server = "https://opendata.aemet.es/opendata";
		String apikey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMTAxNjJAaWVzc2llcnJhZGVndWFyYS5jb20iLCJqdGkiOiIyNWVmYTRiYi00OWYzLTRkYWEtYTAwNS01ZDAzN2Q2OGIyZDkiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3NTE1NDYxMiwidXNlcklkIjoiMjVlZmE0YmItNDlmMy00ZGFhLWEwMDUtNWQwMzdkNjhiMmQ5Iiwicm9sZSI6IiJ9.EBa9x1juCZfg4hR5ce_IJZXLgpnuSx5LvVSXywzwFio";
		String endpoint = "/api/observacion/convencional/todas";

		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder().uri(URI.create(server + endpoint + "?api_key=" + apikey)).GET()
				.build();

		HttpResponse<String> res = cliente.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(res.body());
		System.out.println(res);
	}
}
