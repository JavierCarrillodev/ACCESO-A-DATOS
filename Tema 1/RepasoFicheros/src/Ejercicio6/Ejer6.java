package Ejercicio6;

import java.io.*;

public class Ejer6 {
    public static void main(String[] args) {
        File ruta = new File("Ejercicio6/fichero6.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
                bw.write("1:Juan:99" + "\n");
                bw.write("2:Alex:6" + "\n");
                bw.write("3:Pepe:2" + "\n");
                bw.close();
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = br.readLine()) !=null){
                String[] lineaSepara = linea.split(":");
                System.out.println(lineaSepara[1]);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

