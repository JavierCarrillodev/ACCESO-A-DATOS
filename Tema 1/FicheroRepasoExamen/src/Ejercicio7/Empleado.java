package Ejercicio7;

public class Empleado {
    private String nombre;
    private int edad;
    private String profesion;
    private double sueldo;

    public Empleado(String nombre, int edad, String profesion, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", profesion='" + profesion + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
