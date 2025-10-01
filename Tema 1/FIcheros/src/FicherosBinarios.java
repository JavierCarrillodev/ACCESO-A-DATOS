import java.io.*;

public class FicherosBinarios {
    public static void main(String[] args) {
        File file = new File("binario.bin");



        try{
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(25);
            dos.writeDouble(6.5);
            dos.writeUTF("Hola clase DAM");

            dos.close();
            fos.close();
            System.out.println("Datos escrito correctamente");


        } catch (Exception e) {
            e.printStackTrace();
        }
        // Lectura de datos en binario

        try{
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            int edad = dis.readInt();
            double pi = dis.readDouble();
            String saludo = dis.readUTF();
            dis.close();
            fis.close();

            System.out.println("Entero leido " + edad);
            System.out.println("double leido " + pi);
            System.out.println("Entero texto " + saludo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
