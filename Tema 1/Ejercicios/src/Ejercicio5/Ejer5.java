package Ejercicio5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejer5 {
    public static void main(String[] args) {
        try{

            BufferedWriter bw = new BufferedWriter(new FileWriter("producto.txt"));
            bw.write("1;Teclado;25.5\n");
            bw.write("2;Raton;15.0\n");
            bw.write("3;Monitor;200.0\n");
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("producto.txt"));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("producto_acutualizado.txt"));

            double aumento = 10;
            String linea;
            while ((linea = br.readLine()) != null){
                String[] lineseparada = linea.split(";");
                Producto producto = new Producto(Integer.parseInt(lineseparada[0]),lineseparada[1],Double.parseDouble(lineseparada[2]));
                double aumentoPrecio = producto.getPrecio() * (aumento/100) + producto.getPrecio();

                bw2.write(producto.getId() + ";" + producto.getNombre()  + ";"+ aumentoPrecio + "\n");

            }

            br.close();
            bw2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
