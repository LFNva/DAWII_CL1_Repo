package com.example.DAWII_CL1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "asistencia")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdAsistencia;
    @Column(name = "fecha")
    private Date Fecha;
    @Column(name = "asistio")
    private Boolean Asistio;
    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;
}
