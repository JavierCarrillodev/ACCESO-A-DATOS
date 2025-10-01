package Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejer3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("nombresAlu.txt"));
            System.out.println("Introduce nombres de alumnos");
            String nombres = sc.nextLine();
            while (!nombres.equalsIgnoreCase("fin")){
                bw.write(nombres + "\n");
                System.out.println("Introduce nombres de alumnos");
                nombres = sc.nextLine();

             }
            bw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
