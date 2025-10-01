package Ejercicio1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejer1 {
    public static void main(String[] args) {
       // fichero1();
//        fichero2();
//        fichero3();
//        fichero4();
        fichero5();

    }
    public static void fichero1(){


    try{
        File fichero = new File("Nombres.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
        bw.write("1;Juan;90\n");
        bw.write("2;Pepe;60\n");
        bw.write("3;Carlos;40\n");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) !=null){
            String[] nombre = linea.split(";");
            System.out.println(nombre[1]);
        }

        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public static void fichero2(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("fichero2.txt"));
            bw.write("6\n");
            bw.write("8\n");
            bw.write("7\n");
            bw.write("8\n");
            bw.close();

            ArrayList<Integer> numeros = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader("fichero2.txt"));
            String linea;
            int suma = 0;
            double media = 0;
            while ((linea = br.readLine()) != null){
                numeros.add(Integer.parseInt(linea));
                suma += Integer.parseInt(linea);
               media = (double) suma / numeros.size();


            }
            System.out.println(suma);
            System.out.println(media);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void fichero3(){
        Scanner sc = new Scanner(System.in);
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"));
            BufferedReader br = new BufferedReader(new FileReader("salida.txt"));

            System.out.println("Introduce nombre,fin para terminar");
            String nombre = sc.nextLine();

            while (!nombre.equalsIgnoreCase("fin")){
                System.out.println("Introduce nombre,fin para terminar");
                bw.write(nombre);
                nombre = sc.nextLine();
                bw.newLine();
            }
            bw.close();
            String linea;
            while ((linea = br.readLine()) !=null){
                System.out.println(linea);
            }
            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void fichero4() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("empleado.txt"));
            bw.write("Juan;25;Programador\n");
            bw.write("Ana;30;Diseñadora\n");
            bw.close();
            BufferedReader br = new BufferedReader(new FileReader("empleado.txt"));
            ArrayList<Empleado> empleados = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) !=null){
                String[] empleado = linea.split(";");
                empleados.add(new Empleado(empleado[0],Integer.parseInt(empleado[1]),empleado[2]));

            }
            System.out.println(empleados);
            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void fichero5() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("producto.txt"));
            bw.write("1;Teclado;25.5\n");
            bw.write("2;Raton;15.0\n");
            bw.write("3;Monitor;200.0\n");
            bw.close();
            BufferedReader br = new BufferedReader(new FileReader("producto.txt"));
            String linea;
            while ((linea = br.readLine()) != null){
                String[] productos = linea.split(";");

                double subida = Double.parseDouble(productos[2]) * (10 / 100.0) + Double.parseDouble(productos[2]);




                System.out.println(subida);

            }
            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
