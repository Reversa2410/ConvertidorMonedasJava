import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {


        public Cambio hacerConsulta() {
            try {
                URI direccion = URI.create("https://v6.exchangerate-api.com/v6/0e940156a997e4bdaf465ca5/latest/USD");
                URL url = direccion.toURL(); // Convertimos URI a URL correctamente

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder().uri(direccion).GET().build();

                try {
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    return new Gson().fromJson(response.body(), Cambio.class);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            } catch (IOException e) {
                System.out.println("Error al conectar: " + e.getMessage());
                return null;
            }
        }
    }

