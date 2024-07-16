import Convertidores.ConversionDeCryptos;
import Convertidores.ConversionDeMonedas;
import Excepciones.ConversionException;
import java.util.Scanner;

public class PrincipalConversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversionDeMonedas conversionDeMonedas = new ConversionDeMonedas();
        ConversionDeCryptos conversionDeCryptos = new ConversionDeCryptos();

        System.out.println("Bienvenido al conversor de monedas!");

        while (true) {
            System.out.println("Por favor, seleccione una opción:");
            System.out.println("1. Convertir moneda convencional");
            System.out.println("2. Convertir criptomoneda");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto a convertir: ");
                    double monto = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ingrese la moneda de origen (por ejemplo USD): ");
                    String monedaOrigen = scanner.nextLine().toUpperCase();

                    System.out.print("Ingrese la moneda de destino (por ejemplo EUR): ");
                    String monedaDestino = scanner.nextLine().toUpperCase();

                    try {
                        double resultado = conversionDeMonedas.convertir(monto, monedaOrigen, monedaDestino);
                        System.out.println("Resultado de la conversión: " + resultado + " " + monedaDestino);
                    } catch (ConversionException e) {
                        System.out.println("Error en la conversión: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el monto a convertir: ");
                    double montoCrypto = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea después del nextDouble()

                    System.out.print("Ingrese la criptomoneda de origen (por ejemplo BTC): ");
                    String criptoOrigen = scanner.nextLine().toUpperCase();

                    System.out.print("Ingrese la criptomoneda de destino (por ejemplo ETH): ");
                    String criptoDestino = scanner.nextLine().toUpperCase();

                    try {
                        double resultadoCrypto = conversionDeCryptos.convertir(montoCrypto, criptoOrigen, criptoDestino);
                        System.out.println("Resultado de la conversión: " + resultadoCrypto + " " + criptoDestino);
                    } catch (ConversionException e) {
                        System.out.println("Error en la conversión: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Gracias por usar nuestro conversor de monedas. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
            }
        }


    }
}
