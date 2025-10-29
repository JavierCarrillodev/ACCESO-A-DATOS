package Ejercicio7;

import java.io.*;

/*
Juan;25;Programador;2500
Ana;35;Diseñadora;3200
Luis;45;Jefe;5000

✏️ Tareas:
Leer el fichero y crear objetos Empleado
Mostrar solo los mayores de 30
Aumentar sueldos un 10%
Guardar los nuevos datos en empleados_actualizados.txt
*/
public class Ejer7 {
    public static void main(String[] args) {

        File rutaArchivo = new File("src/Ejercicio7/empleados.txt");
        File rutaArchivoActualizado = new File("src/Ejercicio7/empleados_actualizado.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoActualizado));
            String linea;
            while ((linea = br.readLine()) != null){
                String[] separarPalabras = linea.split(";");
                Empleado empleado = new Empleado(separarPalabras[0],Integer.parseInt(separarPalabras[1]),separarPalabras[2],Double.parseDouble(separarPalabras[3]));
                if (empleado.getEdad() > 30){
                    System.out.println(empleado);
                }
                double aumentoSueldo =  10 * (empleado.getSueldo() / 100) + empleado.getSueldo();
                empleado.setSueldo(aumentoSueldo);
                bw.write(empleado.getNombre() + ";" + empleado.getEdad() + ";" + empleado.getProfesion() + ";" + empleado.getSueldo() + "\n");
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
