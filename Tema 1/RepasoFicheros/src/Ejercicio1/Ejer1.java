package Ejercicio1;

import java.io.*;

public class Ejer1 {
    public static void main(String[] args) {


        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("Nombres.txt"));
            bw.write("1:Juan:20\n");
            bw.write("2:Paco:2\n");
            bw.write("3:Javi:4\n");
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("Nombres.txt"));
            String linea;
            while ((linea = br.readLine()) !=null){
                String[] separar = linea.split(":");

                System.out.println(separar[1]);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
