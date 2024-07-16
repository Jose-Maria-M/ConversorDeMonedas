package Convertidores;

import Excepciones.ConversionException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

    public class ConversionDeMonedas {
        private static final String API_KEY = "85fb38a02aa98fb9ecd2fd4e"; //clave de API de ExchangeRate-API

        public double convertir(double monto, String monedaOrigen, String monedaDestino) throws ConversionException {
            try {
                URL url = new URL("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                // Leer respuesta de API
                Scanner scanner = new Scanner(conn.getInputStream());
                StringBuilder respuesta = new StringBuilder();
                while (scanner.hasNextLine()) {
                    respuesta.append(scanner.nextLine());
                }
                scanner.close();

                // Convertir respuesta JSON a objeto JsonObject usando Gson
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(respuesta.toString(), JsonObject.class);

                // Obtener la tasa de cambio del JsonObject
                double tasaDeCambio = jsonResponse.get("conversion_rate").getAsDouble();

                return monto * tasaDeCambio;

            } catch (IOException e) {
                throw new ConversionException("Error al conectarse con la API: " + e.getMessage());
            }
        }
    }


