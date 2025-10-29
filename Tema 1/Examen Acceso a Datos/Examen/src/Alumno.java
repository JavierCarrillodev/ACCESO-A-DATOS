public class Alumno {
    private String nombre;
    private String apellidos;
    private String fechaNaciemiento;
    private String clase;

    public Alumno(String nombre, String apellidos, String fechaNaciemiento, String clase) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNaciemiento = fechaNaciemiento;
        this.clase = clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public void setFechaNaciemiento(String fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNaciemiento=" + fechaNaciemiento +
                ", clase='" + clase + '\'' +
                '}';
    }
}
