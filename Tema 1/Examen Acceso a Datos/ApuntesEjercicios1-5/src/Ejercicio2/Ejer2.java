package Ejercicio2;

import java.io.*;
import java.util.ArrayList;

public class Ejer2 {
    public static void main(String[] args) {


        File file = new File("ApuntesEjercicios1-5/src/Ejercicio2/fichero2.txt");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("1\n");
            bw.write("2\n");
            bw.write("3\n");
            bw.write("4\n");
            bw.write("5\n");
            bw.close();

            ArrayList<Integer> numeros = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = br.readLine()) !=null){
                int numero = Integer.parseInt(linea);
                numeros.add(numero);
            }
            System.out.println(numeros);
            br.close();


            int suma = 0;
            double media = 0;

            for (int num: numeros){
                suma += num;
                media = (double) suma / numeros.size();
            }
            System.out.println("Suma de los numeros " + suma);
            System.out.println("Media de los numeros " + media);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
