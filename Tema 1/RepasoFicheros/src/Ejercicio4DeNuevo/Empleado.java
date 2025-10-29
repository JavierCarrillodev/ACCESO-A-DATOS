package Ejercicio4DeNuevo;

public class Empleado {
    private String nombre;
    private int edad;
    private String profesion;

    public Empleado(String nombre,int edad,String profesion){
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return  nombre  + ";" +
                edad +  ";" +
                profesion;
    }
}
