package com.example.proyectoBackendOdontolo.controller;

import com.example.proyectoBackendOdontolo.dto.PacienteDto;
import com.example.proyectoBackendOdontolo.dto.PacienteFullDto;
import com.example.proyectoBackendOdontolo.exception.ResourceNotFoundException;
import com.example.proyectoBackendOdontolo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private  PacienteService pacienteService;


    @GetMapping
    public ResponseEntity<List<PacienteDto>> traerPacientes() {

        return ResponseEntity.ok(pacienteService.listar());
    }

    @PostMapping
    public ResponseEntity<PacienteFullDto> registrarPacientes(@Valid @RequestBody PacienteFullDto pacienteFullDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(pacienteService.agregar(pacienteFullDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> BuscarPaciente(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(pacienteService.buscar(id));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
     pacienteService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<PacienteDto> modificar(@Valid @PathVariable Integer id, @RequestBody PacienteDto pacienteDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(pacienteService.modificar(id, pacienteDto));
    }




}
