package mx.unison;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Contar cuantos códigos postales corresponden a asentamientos rurales y cuantos a asentamientos rurales
 */

public class Main {
    public static void main(String[] args) {

        String archivo = "C:\\Users\\dany0\\codigospostales1\\codigos_postales.csv";
        String linea;
        int urbanos = 0;
        int rurales = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine();
            while((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String Asentamiento = datos[2].trim().toLowerCase();
                if (Asentamiento.equals("urbano")){
                    urbanos++;
                } else if (Asentamiento.equals("rural")) {
                    rurales++;
                }
            }
        }catch (IOException e){
            System.out.println("Error al leer el archivo");
        }
        System.out.println("Asentamientos urbanos: " + urbanos);
        System.out.println("Asentamientos rurales: " + rurales);

    }
}