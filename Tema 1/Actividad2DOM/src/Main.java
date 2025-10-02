import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            File rutaXml = new File("files/catalogo.xml");
            List<Libro> libros = DomReader.read(rutaXml);
            libros.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
