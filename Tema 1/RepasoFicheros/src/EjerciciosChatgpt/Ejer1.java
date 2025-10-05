package EjerciciosChatgpt;

import javax.annotation.processing.Filer;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ejer1 {
    public static void main(String[] args) {
        File archivo = new File("EjerciciosChatgpt/Fichero.txt");

        try {
            if (archivo.exists()){
                System.out.println("Ya existe el fichero");
            }else {
                archivo.createNewFile();
                System.out.println("Se acaba de crear");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true));
            bw.write("Pedro");
            bw.newLine();
            bw.write("Jesus");
            bw.newLine();
            bw.write("Jav");
            bw.newLine();
            bw.write("Pepe");
            bw.newLine();
            bw.write("Santiago");
            bw.close();
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) !=null){
                System.out.println(linea);
                contador++;
            }
            System.out.println(contador);
            br.close();


            Path origen = Path.of("EjerciciosChatgpt/Fichero.txt");
            Path destino = Path.of("EjerciciosChatgpt/FicheroCopia.txt");

            Files.copy(origen,destino, StandardCopyOption.REPLACE_EXISTING);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
