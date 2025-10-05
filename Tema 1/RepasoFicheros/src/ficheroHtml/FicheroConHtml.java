package ficheroHtml;

import java.io.*;

public class FicheroConHtml {
    public static void main(String[] args) {
        File ruta = new File("ficheroHtml/index.html");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write("<html>");
            bw.newLine();
            bw.write("<head>");
            bw.newLine();

            bw.write("<title> Ejercicio 3 </title>");
            bw.write("");
            bw.newLine();
            bw.write("<body>");
            bw.newLine();

            bw.write("<h1>Hola mundo </h1>");
            bw.newLine();
            bw.write("</body>");
            bw.newLine();
            bw.write("</head>");
            bw.newLine();
            bw.write("</html>");

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
