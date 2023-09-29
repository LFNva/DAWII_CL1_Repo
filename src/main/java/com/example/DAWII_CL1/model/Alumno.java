package com.example.DAWII_CL1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data

@Table (name = "alumnos")
public class Alumno {

    @Id
    private Integer IdAlumno;
    @Column(name = "ApeAlumno")
    private String ApeAlumno;
    @Column(name = "NomAlumno")
    private String NomAlumno;
    @Column(name = "Proce")
    private String Proce;
    @ManyToOne
    @JoinColumn(name = "IdEsp")
    private Especialidad IdEsp;

}
