Instalación

    Clona el repositorio:

    bash

    git clone https://github.com/tu_usuario/ConversorDeMonedas.git

    Importa el proyecto en tu IDE favorito (Eclipse, IntelliJ IDEA, etc.).

    Asegúrate de tener las dependencias necesarias configuradas (como Gson para manejar JSON, si es necesario).

Uso

    Configura tu API Key de ExchangeRate-API en la clase ConversionDeMonedas:

    java

private static final String API_KEY = "tu_api_key";

Ejemplo de código para realizar una conversión:

java

    public static void main(String[] args) {
        ConversionDeMonedas conversor = new ConversionDeMonedas();
        try {
            double montoConvertido = conversor.convertir(100.0, "USD", "EUR");
            System.out.println("100 USD equivalen a " + montoConvertido + " EUR");
        } catch (ConversionException e) {
            System.err.println("Error al convertir monedas: " + e.getMessage());
        }
    }

Contribución

¡Gracias por considerar contribuir a este proyecto! Si deseas colaborar, sigue estos pasos:

    Realiza un fork del repositorio.
    Crea una nueva rama (git checkout -b feature/nueva_funcionalidad).
    Realiza tus cambios y haz commit (git commit -am 'Agregado nueva funcionalidad').
    Haz push a la rama (git push origin feature/nueva_funcionalidad).
    Crea un pull request en GitHub.

Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo LICENSE para más detalles.
