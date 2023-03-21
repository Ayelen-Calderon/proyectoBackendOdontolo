package com.example.proyectoBackendOdontolo.controller;

import com.example.proyectoBackendOdontolo.dto.TurnoFullDto;
import com.example.proyectoBackendOdontolo.dto.OdontologoFullDto;
import com.example.proyectoBackendOdontolo.exception.ResourceNotFoundException;
import com.example.proyectoBackendOdontolo.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("/turnos")

public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public ResponseEntity<List<TurnoFullDto>> traerTurnos() {
        return ResponseEntity.ok(turnoService.listar());
    }

    @PostMapping
    public ResponseEntity<TurnoFullDto> registrarTurno(@Valid @RequestBody TurnoFullDto turnoFullDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.guardar(turnoFullDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        turnoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");


    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoFullDto> BuscarOdontologo(@PathVariable Integer id) throws ResourceNotFoundException {

        return ResponseEntity.ok(turnoService.buscar(id));
    }

 /*   @PatchMapping("/{id}")
    public ResponseEntity<TurnoFullDto> modificar(@PathVariable Integer id, @RequestBody TurnoFullDto turnoFullDtoDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.modificar(id, turnoFullDtoDto));

    }*/

}
