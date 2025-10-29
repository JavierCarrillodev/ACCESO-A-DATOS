package Ejercicio3;

import java.io.*;
import java.util.Scanner;

public class Ejer3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File rutaArchivo = new File("src/Ejercicio3/ciudades.txt");

        System.out.println("Introduce nombres de tus ciudades favoritas, si quierers terminar escribre fin");
        String ciudades = sc.nextLine();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));
            while (!ciudades.equalsIgnoreCase("fin")) {
                bw.write(ciudades);
                bw.newLine();
                System.out.println("Introduce nombres de tus ciudades favoritas, si quierers terminar escribre fin");
                ciudades = sc.nextLine();

            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
