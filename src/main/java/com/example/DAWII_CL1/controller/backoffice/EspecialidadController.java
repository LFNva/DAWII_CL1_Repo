package com.example.DAWII_CL1.controller.backoffice;

import com.example.DAWII_CL1.model.Especialidad;
import com.example.DAWII_CL1.service.EspecialidadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
public class EspecialidadController {

private EspecialidadService especialidadService;

@GetMapping("/listar")
@ResponseBody
public List<Especialidad> listarEspecialidad()
{
return especialidadService.listarEspecialidad();
}
}