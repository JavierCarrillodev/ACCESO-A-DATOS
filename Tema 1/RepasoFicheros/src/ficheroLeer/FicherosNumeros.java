package ficheroLeer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FicherosNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try {
            System.out.println("Introduce un numero positivo");
            int numeros = sc.nextInt();

            BufferedWriter bw = new BufferedWriter(new FileWriter("ficheroLeer/numeros.txt"));

           for (int i = 1; i <= numeros; i++){
               bw.write(String.valueOf(i));
               bw.newLine();
           }
           bw.close();

            BufferedReader br = new BufferedReader(new FileReader("ficheroLeer/numeros.txt"));
            String linea;
            while ((linea = br.readLine()) !=null){
                System.out.println(linea);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
