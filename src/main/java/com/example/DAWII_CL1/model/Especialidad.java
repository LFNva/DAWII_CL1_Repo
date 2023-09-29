package com.example.DAWII_CL1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
@Entity
@NoArgsConstructor
@Data
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEsp;
    @Column(name = "nomesp")
    private String NomEsp;
    @Column(name = "costo")
    private Double Costo;

}
