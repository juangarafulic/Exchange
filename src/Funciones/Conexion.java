package Funciones;

import Modelos.ApiKey;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {
    // Configurando url
    ApiKey apiKey = new ApiKey();
    String url = "https://v6.exchangerate-api.com/v6/" + apiKey.getApiKey() + "/latest/USD";

    public String Conexion(ApiKey apiKey, String url) throws IOException, InterruptedException {
        // Implementando la comunicación con el web service
        // Construyendo el Cliente para Solicitudes (HttpClient)
        HttpClient client = HttpClient.newHttpClient();
        // Construyendo la Solicitud (HttpRequest)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        // Construyendo la Respuesta (HttpResponse)
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        return json;

    }
}
