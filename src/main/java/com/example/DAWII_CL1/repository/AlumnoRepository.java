package com.example.DAWII_CL1.repository;

import com.example.DAWII_CL1.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
}
