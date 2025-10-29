package EjerciciosChatgpt;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ejer2 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("EjerciciosChatgpt/Fichero.txt"));
            String linea;
            int contadorPalabras = 0;

            while ((linea = br.readLine()) != null){
                linea.trim();

                if (!linea.isEmpty()){
                    String[] palabras = linea.split("\\s+");
                    contadorPalabras += palabras.length;

                    for(String palabra:palabras){
                        System.out.println(palabra);
                    }
                }

            }
            System.out.println(contadorPalabras);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
