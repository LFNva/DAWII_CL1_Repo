package com.example.DAWII_CL1.controller.backoffice;

import com.example.DAWII_CL1.model.Alumno;
import com.example.DAWII_CL1.model.Especialidad;
import com.example.DAWII_CL1.request.AlumnoRequest;
import com.example.DAWII_CL1.response.ResultadoResponse;
import com.example.DAWII_CL1.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaAlumnos",alumnoService.listarAlumnos());
        return "/alumno/frmMantalumno";
    }

    @GetMapping("/listarAlumnos")
    @ResponseBody
    public List<Alumno> listarAlumnos(){
        return alumnoService.listarAlumnos();
    }

    @PostMapping("/guardarAlumno")
    @ResponseBody
    public ResultadoResponse guardarAlumno(@RequestBody AlumnoRequest alumnoRequest){
        return alumnoService.guardarAlumno(alumnoRequest);
    }

    @DeleteMapping("/eliminarAlumno")
    @ResponseBody
    public ResultadoResponse eliminarAlumno(@RequestBody AlumnoRequest alumnoRequest){
        String mensaje = "Alumno Eliminado Correctamente";
        Boolean respuesta = true;
        try{
            alumnoService.eliminarAlumno(alumnoRequest.getIdalumno());
        }catch(Exception e){
            mensaje = "Alumno no Eliminado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
