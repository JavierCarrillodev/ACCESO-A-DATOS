package Ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Ejer2 {
    public static void main(String[] args) {

        try{

            ArrayList<Integer> numeros = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("numeros.txt"));
            String linea;
            int suma = 0;
            while ((linea = br.readLine()) !=null){
                numeros.add(Integer.parseInt(linea));
                suma += Integer.parseInt(linea);

            }
            br.close();
            for (int numero:numeros){
                System.out.println(numero);
            }
            System.out.println(suma);
           double media = (double) suma / numeros.size();
            System.out.println(media);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
