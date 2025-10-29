package com.primerProyecto.PrimerProyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "peliculas")
@Data // Lombok genera getters, setters, toString, equals, hashCode
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 120)
    private String titulo;

    private int duracion; //minutos

    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;

    private String sinopsis;



}
