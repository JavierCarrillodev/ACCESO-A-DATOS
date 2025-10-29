package Ejercicio7;

import java.io.*;
import java.util.ArrayList;

public class Ejer7 {
    public static void main(String[] args) {
        File ruta = new File("Ejercicio7/fichero7.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write("6" + "\n");
            bw.write("8" + "\n");
            bw.write("10" + "\n");
            bw.close();
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;
            ArrayList<Integer> numeros = new ArrayList<>();
            int numeroInt = 0;
            while ((linea = br.readLine()) !=null){
                numeroInt = Integer.parseInt(linea);
                numeros.add(numeroInt);
            }
            int suma = 0;
            double media = 0;
            for (int numero: numeros){
                suma += numero;
                media = (double) suma / numeros.size();
            }
            System.out.println("La suma es " + suma);
            System.out.println("La media es " + media);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
