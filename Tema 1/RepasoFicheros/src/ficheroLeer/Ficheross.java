package ficheroLeer;

import java.io.*;
import java.util.Scanner;

public class Ficheross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("ficheroLeer/vehiculos.txt",true));
            System.out.println("Introduce la matricula");
            String matricula = sc.nextLine();
            dos.writeUTF(matricula);

            System.out.println("Introduce la marca");
            String marca = sc.nextLine();
            dos.writeUTF(marca);

            System.out.println("Introduce la modelo");
            String modelo = sc.nextLine();
            dos.writeUTF(modelo);

            dos.close();

//            DataInputStream dis = new DataInputStream(new FileInputStream("ficheroLeer/vehiculos.txt"));
//            String linea;
//            while ((linea = dis.readUTF()) !=null){
//                System.out.println(linea);
//            }
//            dis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
