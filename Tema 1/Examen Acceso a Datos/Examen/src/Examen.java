import javax.annotation.processing.Filer;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Examen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce apellidos");
        String apellidos = sc.nextLine();
        System.out.println("Fecha de naciemiento");
        String fechaNacimiento = sc.nextLine();
        System.out.println("Introduce la clase del alumno");
        String claseAlumno = sc.nextLine();




        File rutaArchivo = new File("Examen/src/Alumnos.txt");


        try {
            if (!rutaArchivo.exists()){
                rutaArchivo.createNewFile();
            }else {
                System.out.println("Ya esta creado");
            }
            ArrayList<Alumno> alumnos = new ArrayList<>();
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));
            bw.write(nombre + "|");

            bw.write(apellidos + "|");

            bw.write(fechaNacimiento + "|");

            bw.write(claseAlumno + "|");


            bw.close();

            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String lineas;
            while ((lineas = br.readLine()) != null){
                String[] lineasSeparadas = lineas.split(";");
                Alumno alumno = new Alumno(lineasSeparadas[0],lineasSeparadas[1],lineasSeparadas[2],lineasSeparadas[3]);
                System.out.println();
            }
            br.close();

        } catch (Exception e) {

        }

    }
}
