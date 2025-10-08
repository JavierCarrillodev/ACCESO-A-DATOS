package SAX;

import java.util.ArrayList;

public class Libro {
    private String id;
    private String isbn;
    private String title;
    private ArrayList<String> authors;
    private ArrayList<String> categories;
    private int year;
    private double price;
    private String moneda;



    public Libro() {
        this.authors = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public void addAuthor(String autor){
        this.authors.add(autor);
    }

    public void addCategorias(String categoria){
        this.categories.add(categoria);
    }

    @Override
    public String toString() {
        return "["+ id +"] " + title + "(" + year + ")" + "\n" +
               "ISBN" + ": "  + isbn + "\n" +
               "Autores" + ": " + authors + "\n" +
               "Categorias" + ": " + categories + "\n" +
               "Precio" + ": " + price + " " + moneda + "\n";

    }
}