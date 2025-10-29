package Ejercicio2DeNuevo;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.ArrayList;

public class Ejercicio2_2 {
    public static void main(String[] args) {
        File rutaArchivo = new File("Ejercicio2DeNuevo/Fichero.txt");

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));
            bw.write("6" + "\n");
            bw.write("7" + "\n");
            bw.write("8" + "\n");
            bw.write("9" + "\n");
            bw.close();

            ArrayList<Integer> numeros = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            int convertirNumeros = 0;
            int suma = 0;
            double media = 0;
            while ((linea = br.readLine()) != null){
                convertirNumeros = Integer.parseInt(linea);
                numeros.add(convertirNumeros);
                suma += convertirNumeros;
                 media = (double) suma / numeros.size();
            }
            System.out.println("La suma es " + suma);
            System.out.println( "La media es " + media);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
