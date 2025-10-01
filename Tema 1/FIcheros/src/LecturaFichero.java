import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LecturaFichero {
    public static void main(String[] args) {
        try{
            File file = new File("mi_fichero.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            //ejemplo misma linea
            //BufferedRead br2 = new BuffereReader(new FileReader)

            String s;
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}