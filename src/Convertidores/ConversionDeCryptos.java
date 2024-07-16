package Convertidores;

import Excepciones.ConversionException;
import Excepciones.IOException;

public class ConversionDeCryptos {
    private static final String API_KEY = "tu_api_key_aqui"; // Clave API ficticia para demostración

    public double convertir(double cantidad, String criptoOrigen, String criptoDestino) throws ConversionException {
        try {
            // Simulación de una API ficticia para obtener tasas de cambio de criptomonedas
            double tasaDeCambio = obtenerTasaDeCambio(criptoOrigen, criptoDestino);
            return cantidad * tasaDeCambio;
        } catch (IOException e) {
            throw new ConversionException("Error al obtener la tasa de cambio de criptomonedas: " + e.getMessage());
        }
    }

    private double obtenerTasaDeCambio(String criptoOrigen, String criptoDestino) throws IOException {
        // Simulación de la obtención de la tasa de cambio desde una API ficticia
        // Aquí se simula la obtención de la tasa de cambio entre criptomonedas
        // en una API ficticia, para demostración
        // En un entorno real, aquí se realizaría una solicitud HTTP a una API real

        // Simulación de una respuesta de API ficticia
        double tasaDeCambio = 0.0025; // Ejemplo de tasa de cambio ficticia para demostración
        return tasaDeCambio;
    }
}
