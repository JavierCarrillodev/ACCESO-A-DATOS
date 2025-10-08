package Ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Ejer4 {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Ejercicio4/empleados.txt"));
            String linea;
            while ((linea = br.readLine()) !=null){
               String[] lineaSeparar = linea.split(";");
                empleados.add(new Empleado(lineaSeparar[0], Integer.parseInt(lineaSeparar[1]), lineaSeparar[2]));

            }
            br.close();
            System.out.println(empleados);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
