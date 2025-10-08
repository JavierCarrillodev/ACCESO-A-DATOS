package Ejercicio4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejer4 {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("ApuntesEjercicios1-5/src/Ejercicio4/empleados.txt"));
            bw.write("Juan;25;Programador\n");
            bw.write("Ana;30;Diseñadora\n");
            bw.close();


            BufferedReader br = new BufferedReader(new FileReader("ApuntesEjercicios1-5/src/Ejercicio4/empleados.txt"));
            String linea;

            while ((linea = br.readLine()) !=null){
                String[] lineaSeparar = linea.split(";");
                empleados.add(new Empleado(lineaSeparar[0],Integer.parseInt(lineaSeparar[1]),lineaSeparar[2]));


            }
            System.out.println(empleados);






        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
