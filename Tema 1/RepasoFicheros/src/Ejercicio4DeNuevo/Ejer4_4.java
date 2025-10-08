package Ejercicio4DeNuevo;

import java.io.*;
import java.util.ArrayList;

public class Ejer4_4 {
    public static void main(String[] args) {
        File rutaArchivo = new File("Ejercicio4DeNuevo/empleados.txt");

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));
            bw.write( "Juan;25;Programador" + "\n");
            bw.write( "Ana;30;Diseñadora" + "\n");
            bw.close();

            ArrayList<Empleado> empleados = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = br.readLine()) != null){
                String[] palabrasSeparar = linea.split(";");
                empleados.add(new Empleado(palabrasSeparar[0],Integer.parseInt(palabrasSeparar[1]),palabrasSeparar[2]));
            }
            br.close();
            System.out.println(empleados);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
