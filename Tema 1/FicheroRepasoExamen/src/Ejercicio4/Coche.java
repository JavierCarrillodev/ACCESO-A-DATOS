package Ejercicio4;

public class Coche {
    private String marca;
    private String modelo;
    private int ano;

    public Coche(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + "," +
                "Modelo: " + modelo + "," +
                "Año: " + ano;
    }
}
