package com.example.DAWII_CL1.service;

import com.example.DAWII_CL1.model.Especialidad;
import com.example.DAWII_CL1.repository.EspecialidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EspecialidadService {

    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> listarEspecialidad(){
        return especialidadRepository.findAll();

    }

    }


