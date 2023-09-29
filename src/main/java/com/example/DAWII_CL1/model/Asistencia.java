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
    private Integer IdAsistencia;
    @Column(name = "Fecha")
    private Date Fecha;
    @Column(name = "Asistio")
    private Boolean Asistio;
    @ManyToOne
    @JoinColumn(name = "IdAlumno")
    private Alumno IdAlumno;
}
