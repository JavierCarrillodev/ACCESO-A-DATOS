package Ejercicio1;

import java.io.*;


public class Ejer1{
    public static void main(String[] args) {
         try{
             File file = new File("Ejercicios/src/Ejercicio1/fichero1.txt");
             BufferedWriter bw = new BufferedWriter(new FileWriter(file));
             bw.write("1:Pepe:99\n");
             bw.write("2:Pedro:16\n");
             bw.write("3:Carlos:6\n");
             bw.write("4:Lucas:19\n");
             bw.close();
             System.out.println("Escritura correcta");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea;
                while ((linea = br.readLine()) !=null){
                    String[] nombre = linea.split(":");
                    System.out.println(nombre[1]);
                }


             br.close();

         }catch (Exception e) {
             e.printStackTrace();
         }
    }
}
