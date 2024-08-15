package mx.unison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EncontrarCodigo {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, proporciona al menos un código postal como argumento.");
            return;
        }

        String csvFile = "C:\\Users\\dany0\\codigospostales1\\codigos_postales.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            for (String codigoPostal : args) {
                boolean encontrado = false;

                // Reiniciar la lectura del archivo para cada código postal
                br.mark(100000); // Marcar la posición al principio del archivo

                while ((line = br.readLine()) != null) {
                    String[] datos = line.split(csvSplitBy);
                    String codigoPostalArchivo = datos[0];
                    String asentamiento = datos[1];

                    if (codigoPostalArchivo.equals(codigoPostal)) {
                        System.out.println("Código Postal: " + codigoPostal + " - Asentamiento: " + asentamiento);
                        encontrado = true;
                    }
                }

                // Si no se encuentra el código postal
                if (!encontrado) {
                    System.out.println("Código Postal: " + codigoPostal + " no encontrado.");
                }

                br.reset(); // Volver al principio del archivo para buscar el siguiente código postal
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
