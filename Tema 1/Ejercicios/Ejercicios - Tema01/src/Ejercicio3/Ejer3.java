package Ejercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejer3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ejercicios/src/Ejercicio3/salida.txt"));

            String linea;
            while (true){
                System.out.println("Indica nombres de alumnos, y si quierer terminar pon fin");
                linea = sc.nextLine();
                if (linea.equalsIgnoreCase("fin")){
                    break;
                }
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
            System.out.println("Guardado correctamente");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
