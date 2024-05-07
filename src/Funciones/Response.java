package Funciones;

import Modelos.ApiKey;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Response {
    ApiKey apiKey = new ApiKey();
    String url = "https://v6.exchangerate-api.com/v6/" + apiKey.getApiKey() + "/latest/USD";
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

    public String getJson() throws IOException, InterruptedException {
    HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body(); //return json
    }


}
