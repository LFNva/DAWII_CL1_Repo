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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdAlumno;
    @Column(name = "apealumno")
    private String ApeAlumno;
    @Column(name = "nomalumno")
    private String NomAlumno;
    @Column(name = "proce")
    private String Proce;
    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialidad;

}
