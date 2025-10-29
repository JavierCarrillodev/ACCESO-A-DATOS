package Ejercicio10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Ejer10 {
    public static void main(String[] args) {
        try{

            BufferedWriter bw = new BufferedWriter(new FileWriter("Ejercicio10/productos.txt"));
            bw.write("1;Teclado;25.5" + "\n");
            bw.write("2;Raton;15.0" + "\n");
            bw.write("3;Monitor;200.0" + "\n");
            bw.close();
            BufferedReader br = new BufferedReader(new FileReader("Ejercicio10/productos.txt"));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("Ejercicio10/productos_actualizados.txt"));
            String linea;
            while ((linea = br.readLine()) !=null){
                String[] lineaSeparar = linea.split(";");
                Productos producto = new Productos(Integer.parseInt(lineaSeparar[0]),lineaSeparar[1],Double.parseDouble(lineaSeparar[2]));

                double aumento = 10;
                double aumentoPrecio = producto.getPrecio() * (aumento/100) + producto.getPrecio();
                bw2.write(producto.getId() + ";"  + producto.getNombre() + ";" + aumentoPrecio );
                bw2.newLine();


            }
            br.close();
            bw2.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
