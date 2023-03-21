package com.example.proyectoBackendOdontolo.service;

import com.example.proyectoBackendOdontolo.dto.PacienteDto;
import com.example.proyectoBackendOdontolo.dto.PacienteFullDto;
import com.example.proyectoBackendOdontolo.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    void agregar() throws ResourceNotFoundException {
        //Arrange
        PacienteFullDto oDto = new PacienteFullDto("pepita", "fulana","123548","saraza 123", LocalDate.now());
        //Act

        PacienteFullDto result = pacienteService.agregar(oDto);
        //Assert

        assertNotNull(result);
    }
    @Test
    void agregarTestExepciones(){
        //Arrange
        PacienteFullDto oDto = new PacienteFullDto();
        try {
            //Act
            PacienteFullDto result = pacienteService.agregar(oDto);
            //Assert
            fail("Se esperaba excepcion ResourceNotFoundException");

        }catch (ResourceNotFoundException e){}
    }

    @Test
    void buscar() throws ResourceNotFoundException {
        PacienteFullDto oDto = new PacienteFullDto("pepita", "fulana","123548","saraza 123", LocalDate.now());
        PacienteFullDto oDtoGuardado =  pacienteService.agregar(oDto);
        Integer id = oDtoGuardado.id;
        //Act

        PacienteDto result = pacienteService.buscar(id);


        //Assert
        assertNotNull(result);

    }



    @Test
    void eliminar() throws ResourceNotFoundException {

        //Arrange
        PacienteFullDto dto = new PacienteFullDto("pepita", "fulana","123548","saraza 123", LocalDate.now());
        PacienteFullDto oGuardado = pacienteService.agregar(dto);
        Integer id = oGuardado.id;
        //Act

        try {
           pacienteService.eliminar(id);
           pacienteService.buscar(id);
            //Assert
            fail("Se esperaba excepcion ResourceNotFoundException");
        } catch(ResourceNotFoundException e) {}

    }

    @Test
    void listar() throws ResourceNotFoundException {
        //Arrange
        PacienteFullDto dto =  new PacienteFullDto("pepita", "fulana","123548","saraza 123", LocalDate.now());
        pacienteService.agregar(dto);
        //Act
        List<PacienteDto> odontologoDtos = pacienteService.listar();
        //Assert
        assertTrue(odontologoDtos.size()>0);

    }


}