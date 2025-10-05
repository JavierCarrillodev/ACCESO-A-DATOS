package Ejercicio9;

import java.io.*;
import java.util.ArrayList;

public class Ejer9 {
    public static void main(String[] args) {
        File ruta = new File("Ejercicio9/empleados.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write("Juan;25;Programador" + "\n");
            bw.write("Ana;30;Diseñadora" + "\n");
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader(ruta));
            ArrayList<Empleado> empleados = new ArrayList<>();
            String linea;

            while ((linea = br.readLine()) != null){
                String[] lineaSeparar = linea.split(";");
                empleados.add(new Empleado(lineaSeparar[0],Integer.parseInt(lineaSeparar[1]),lineaSeparar[2]));
            }
            System.out.println(empleados);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
