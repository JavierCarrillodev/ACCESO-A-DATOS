package Ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejer6 {
    public static void main(String[] args) {
        File rutaArchivo = new File("src/Ejercicio6/fichero.txt");
        int numerosLineas = 0;
        int numerosPalabras = 0;
        int numerosCaracteres = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String lineas;
            while ((lineas = br.readLine()) != null){
               numerosLineas++;
               String[] palabras = lineas.trim().split("\\s+");
                if (!lineas.trim().isEmpty()) {
                    numerosPalabras += palabras.length;
                }
                // Con trim quitamos los espacios en blanco en el inicio y final.
                //Y el replace podemos quitar los espacios en blanco internos.
               numerosCaracteres += lineas.trim().replace(" ", "").length();

            }
            System.out.println( "Numero de lineas " + numerosLineas);
            System.out.println("Numeros de palabras " + numerosPalabras );
            System.out.println("Numeros caracter " + numerosCaracteres);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
