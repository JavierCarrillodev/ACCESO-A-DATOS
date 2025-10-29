package Ejercicio4;

public class Empleado {
    private String nombre;
    private int edad;
    private String trabajo;

    public Empleado(String nombre, int edad, String trabajo) {
        this.nombre = nombre;
        this.edad = edad;
        this.trabajo = trabajo;
    }
    @Override
    public String toString() {
        return this.nombre + ";" +
                this.edad + ";" +
               this.trabajo ;
    }
}
