package Ejercicio8;

import java.io.*;
import java.util.Scanner;

public class Ejer8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File ruta = new File("Ejercicio8/salidas.txt");
        System.out.println("Introduce nombres y fin para terminar");
        String nombres = sc.nextLine();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            while (!nombres.equalsIgnoreCase("fin")) {
                bw.write(nombres);
                bw.newLine();
                System.out.println("Introduce nombres y fin para terminar");
                nombres = sc.nextLine();

            }
            bw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
