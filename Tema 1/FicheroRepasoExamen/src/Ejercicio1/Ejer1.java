package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejer1 {
    public static void main(String[] args) {

        File rutaArchivo = new File("src/Ejercicio1/personas.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = br.readLine()) != null){
                String[] separarPalabras = linea.split(":");
                System.out.println(separarPalabras[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
