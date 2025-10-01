import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFichero {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("/home/javi/Escritorio/mi_archivo.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("Que maquina");
            fw.close();
            System.out.println("Escritura correcta en fichero");
        } catch (IOException e) {

        }
    }
}
