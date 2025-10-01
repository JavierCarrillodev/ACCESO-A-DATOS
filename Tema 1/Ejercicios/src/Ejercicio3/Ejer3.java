package Ejercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejer3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ejercicios/src/Ejercicio3/salida.txt"));
            System.out.print("Indica nombres de alumnos, y si quierer terminar pon fin: ");
            opcion = sc.nextLine();
            while (!opcion.equalsIgnoreCase("fin")){
                System.out.print("Indica nombres de alumnos, y si quierer terminar pon fin: ");
                bw.write(opcion);
                opcion = sc.nextLine();

                bw.newLine();
            }
            bw.close();
            System.out.println("Guardado correctamente");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
