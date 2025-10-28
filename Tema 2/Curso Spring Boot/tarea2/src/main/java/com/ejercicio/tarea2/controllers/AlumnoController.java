package com.ejercicio.tarea2.controllers;

import com.ejercicio.tarea2.modelo.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/alumnos")


public class AlumnoController {

    private List<Alumno> alumnos = new ArrayList<>(Arrays.asList(
            new Alumno(1,"Javi","carrilo@gmail.com",21,"2Dam"),
            new Alumno(2,"Victoria","vimoji@gmail.com",20,"4Carrera"),
            new Alumno(3,"Oscar","ofher@gmail.com",19,"2Dam"),
            new Alumno(4,"Lola","lolalita@gmail.com",47,"6Dam")
    ));

    //Mostrar todos los alumnos
    @GetMapping
    public List<Alumno> getAlumnos(){
        return alumnos;
    }

    //Consultar un alumno por su email
    @GetMapping(value = "/{email}")
    public Alumno getAlumno(@PathVariable String email){
        for (Alumno alumno:alumnos){
            if (alumno.getEmail().equalsIgnoreCase(email)){
                return alumno;
            }
        }
        return null;
    }

    //Crear un nuevo alumno
    @PostMapping
    public Alumno postAlumno(@RequestBody Alumno alumno){
        alumnos.add(alumno);
        return alumno;
    }


    //Modificacion total de un alumno
    @PutMapping
    public Alumno putAlumno(@RequestBody Alumno alumno){
        for (Alumno alumnado:alumnos) {
            if (alumnado.getID() == alumno.getID()) {
                alumnado.setNombre(alumno.getNombre());
                alumnado.setEmail(alumno.getEmail());
                alumnado.setEdad(alumno.getEdad());
                alumnado.setCurso(alumno.getCurso());

                return alumnado;
            }
        }
        return null;
    }

    //Borramos un alumno
    @DeleteMapping("/{id}")
    public Alumno deleteAlumno(@PathVariable int id){
        for (Alumno alumnado:alumnos) {
            if (alumnado.getID() == id) {
                alumnos.remove(alumnado);
                return alumnado;
            }
        }
        return null;
    }

    //Modificacion parcial de un alumno
    @PatchMapping
    public Alumno patchAlumno(@RequestBody Alumno alumno){
        for (Alumno alumnado:alumnos) {
            if (alumnado.getID() == alumno.getID()){
                if (alumno.getNombre() !=null){
                    alumnado.setNombre(alumno.getNombre());
                }
                if (alumno.getEmail() !=null){
                    alumnado.setEmail(alumno.getEmail());
                }
                if (alumno.getEdad() != 0){
                    alumnado.setEdad(alumno.getEdad());
                }
                if (alumno.getCurso() !=null){
                    alumnado.setCurso(alumno.getCurso());
                }
                return alumnado;
            }
        }
        return null;
    }














}
