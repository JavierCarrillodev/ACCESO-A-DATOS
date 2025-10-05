import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            File rutaXml = new File("files/catalogo.xml");
            List<Libro> libros = DomReader.read(rutaXml);
            for (Libro libro : libros){
                System.out.println(libro);
            }


            System.out.println("------ Consultas------ ");
            System.out.println("");

            System.out.println("-----Mostrar sólo los títulos publicados después de 2010-----");
            for (Libro libro : libros){
                if (libro.getYear() > 2010){
                    System.out.println(libro);
                }
            }

            System.out.println("-----Mostrar los libros con más de un autor-----");
            for (Libro libro : libros){
                if (libro.getAuthors().size() > 1){
                    System.out.println(libro);
                }
            }

            System.out.println("-----Calcular el precio medio en EUR (para los que tengan currency= EUR");
            double suma = 0;
            double media = 0;
            int contador = 0;
            for (Libro libro : libros){
                if (libro.getMoneda().equals("EUR")){
                    contador++;
                     suma += libro.getPrice();
                    media = suma / contador;

                }
            }
            System.out.println("La media en EUR es " + media + "€");



        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
