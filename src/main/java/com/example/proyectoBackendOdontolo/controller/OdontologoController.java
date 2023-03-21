package com.example.proyectoBackendOdontolo.controller;

import com.example.proyectoBackendOdontolo.dto.OdontologoDto;
import com.example.proyectoBackendOdontolo.dto.OdontologoFullDto;
import com.example.proyectoBackendOdontolo.exception.ResourceNotFoundException;
import com.example.proyectoBackendOdontolo.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;
    @GetMapping("/Listar")
    public ResponseEntity<List<OdontologoDto>> traerOdontologos() {
        return ResponseEntity.ok(odontologoService.listar());
    }

    @PostMapping
    public ResponseEntity<OdontologoFullDto> registrarOdontologo(@Valid @RequestBody OdontologoFullDto odontologoFullDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.agregar(odontologoFullDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        odontologoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");


    }
    @GetMapping("buscar/{id}")
    public ResponseEntity<OdontologoDto> BuscarOdontologo(@PathVariable Integer id) throws ResourceNotFoundException {

        return ResponseEntity.ok(odontologoService.buscar(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OdontologoDto> modificar(@Valid @PathVariable Integer id, @RequestBody OdontologoDto odontologoDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.modificar(id, odontologoDto));
    }





}

