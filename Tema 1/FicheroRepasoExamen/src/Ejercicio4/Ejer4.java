package Ejercicio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ejer4 {
    public static void main(String[] args) {
        File rutaArchivo = new File("src/Ejercicio4/coches.txt");

        try {
            ArrayList<Coche> coches = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = br.readLine()) != null){
                String[] palabrasSeparadas = linea.split(";");
                coches.add(new Coche(palabrasSeparadas[0],palabrasSeparadas[1],Integer.parseInt(palabrasSeparadas[2])));

            }
            for (Coche c:coches){
                System.out.println(c);

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
