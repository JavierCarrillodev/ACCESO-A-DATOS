package ficheroLeer;

import java.io.*;
import java.util.Scanner;

public class LeerFicheros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File ruta = new File("ficheroLeer/fichero.txt");

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(ruta,true));
                System.out.println("Introduce lineas de texto, para finalizar pon fin");
                String lineasTexto = sc.nextLine();

                while (!lineasTexto.equalsIgnoreCase("fin")) {
                    bw.write(lineasTexto);
                    bw.newLine();
                    System.out.println("Introduce lineas de texto, para finalizar pon fin");
                    lineasTexto = sc.nextLine();

                }
                bw.close();

                BufferedReader br = new BufferedReader(new FileReader(ruta));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
