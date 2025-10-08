package DOM;

import org.w3c.dom.*; // Element
import javax.xml.parsers.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomReader {

    public static List<Libro> read(File xmlFile) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xmlFile);

        NodeList nodes = doc.getElementsByTagName("book");
        List<Libro> libros = new ArrayList<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Element e = (Element) nodes.item(i);
            Libro b = new Libro();
            b.setId( e.getAttribute("id"));
            b.setIsbn(e.getAttribute("isbn"));
            b.setTitle(textOf(e, "title")) ;

            NodeList authors = e.getElementsByTagName("author");
            for (int j = 0; j < authors.getLength(); j++) {
                String role = ((Element)authors.item(j)).getAttribute("role");
                if (role.isEmpty()){
                    b.addAuthor(authors.item(j).getTextContent());
                }
                else {
                    b.addAuthor(authors.item(j).getTextContent() + " (" + role + ")");
                }
            }

            NodeList categories = e.getElementsByTagName("category");
            for (int j = 0; j < categories.getLength(); j++) {
                b.addCategorias(categories.item(j).getTextContent());
            }

            b.setYear(parseIntSafe(textOf(e, "year")));
            b.setPrice(parseDoubleSafe(textOf(e, "price")));


            NodeList price = e.getElementsByTagName("price");
            b.setMoneda(((Element) price.item(0)).getAttribute("currency"));

            libros.add(b);
        }
        return libros;
    }

    private static String textOf(Element parent, String tag) {
        NodeList nl = parent.getElementsByTagName(tag);
        return (nl.getLength() > 0) ? nl.item(0).getTextContent().trim() : "";
    }

    private static int parseIntSafe(String s) {
        return s.isEmpty() ? 0 : Integer.parseInt(s);
    }

    private static double parseDoubleSafe(String s) {
        return s.isEmpty() ? 0.0 : Double.parseDouble(s);
    }
}