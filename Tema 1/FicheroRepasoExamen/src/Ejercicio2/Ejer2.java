package Ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ejer2 {
    public static void main(String[] args) {
        File rutaArchivo = new File("src/Ejercicio2/numeros.txt");

        try {
            ArrayList<Integer> numeros = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            int suma = 0;
            double media = 0;

            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
                System.out.println(linea);
                suma += Integer.parseInt(linea);
                media = (double) suma / numeros.size();

            }
            br.close();

            System.out.println("La suma es: " + suma);
            System.out.println("La media es: " + media);

            int numeroMayor = Collections.max(numeros);
            System.out.println("El numero mayor es: " + numeroMayor);
            int numeroMenor = Collections.min(numeros);
            System.out.println("El numero menor es: " + numeroMenor);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
