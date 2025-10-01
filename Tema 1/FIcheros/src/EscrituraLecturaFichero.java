import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class EscrituraLecturaFichero {
    public static void main(String[] args) {
        //Funcion que escribe 3 lineas en un fichero y posteriormente lee y muestra por pantalla las 3 lineas
        Ejercicio1();
    }
        public static void Ejercicio1() {


            try {
                //Creamos el fichero escribiendolo
                File file = new File("/home/javi/Documentos/Javi/2DAM/Acceso a datos/Tema 1/FIcheros/hola.txt");
                FileWriter fw = new FileWriter(file, true);
                fw.write("Esto es para recordar\n");
                fw.write("Esto es para recordar\n");
                fw.write("Esto es para recordar");
                fw.close();
                System.out.println("Escritura correcta");
                FileReader fr = new FileReader("/home/javi/Documentos/Javi/2DAM/Acceso a datos/Tema 1/FIcheros/hola.txt");
                BufferedReader br = new BufferedReader(fr);
                String s;
                while ((s = br.readLine()) != null) {
                    System.out.println(s);

                }


            } catch (Exception e) {

            }
        }
        public static void ejercicio2(){
        try{


        } catch (Exception e) {

        }
        }
    }

