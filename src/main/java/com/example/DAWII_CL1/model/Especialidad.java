package com.example.DAWII_CL1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
@Entity
@NoArgsConstructor
@Data
@Table(name = "especialidad")
public class Especialidad {
    @Id
    private Integer IdEsp;
    @Column(name = "NomEsp")
    private String NomEsp;
    @Column(name = "Costo")
    private DecimalFormat Costo;

}
