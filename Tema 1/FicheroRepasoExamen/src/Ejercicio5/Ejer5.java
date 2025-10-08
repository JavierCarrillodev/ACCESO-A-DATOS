package Ejercicio5;

import java.io.*;

public class Ejer5 {
    public static void main(String[] args) {

        File rutaArchivo = new File("src/Ejercicio5/articulos.txt");
        File rutaArchivoActualizado = new File("src/Ejercicio5/articulos_actualizado.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoActualizado));
            String linea;
            while ((linea = br.readLine()) != null){
                String[] separarPalabras = linea.split(";");
                Articulo articulo = new Articulo(Integer.parseInt(separarPalabras[0]),separarPalabras[1],Double.parseDouble(separarPalabras[2]));
                double aumentoPrecio = 5 * (articulo.getPrecio() / 100) + articulo.getPrecio();

                bw.write(articulo.getId() + ";" + articulo.getNombre() + ";" + aumentoPrecio + "\n") ;

            }
            br.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
