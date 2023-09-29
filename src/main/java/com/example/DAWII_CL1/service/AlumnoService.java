package com.example.DAWII_CL1.service;

import com.example.DAWII_CL1.model.Alumno;
import com.example.DAWII_CL1.model.Especialidad;
import com.example.DAWII_CL1.repository.AlumnoRepository;
import com.example.DAWII_CL1.request.AlumnoRequest;
import com.example.DAWII_CL1.response.ResultadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    public ResultadoResponse guardarAlumno(AlumnoRequest alumnoRequest){
        String mensaje = "Alumno Registrado Correctamente";
        Boolean respuesta = true;
        try{
            Alumno objAlumno = new Alumno();

            if(alumnoRequest.getIdalumno() >0){
                objAlumno.setIdAlumno(alumnoRequest.getIdalumno());
            }
            objAlumno.setNomAlumno(alumnoRequest.getNomalumno());
            objAlumno.setApeAlumno(alumnoRequest.getApealumno());
            objAlumno.setProce(alumnoRequest.getProce());
            Especialidad especialidad = new Especialidad();
            especialidad.setIdEsp(alumnoRequest.getIdesp());
            objAlumno.setEspecialidad(especialidad);
            alumnoRepository.save(objAlumno);
        }catch (Exception ex){
            mensaje = "Alumno no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    public void eliminarAlumno(Integer id_alumno){
        alumnoRepository.deleteById(id_alumno);
    }
}
