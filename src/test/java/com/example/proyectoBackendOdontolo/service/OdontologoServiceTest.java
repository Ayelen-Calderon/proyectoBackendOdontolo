package com.example.proyectoBackendOdontolo.service;

import com.example.proyectoBackendOdontolo.dto.OdontologoDto;
import com.example.proyectoBackendOdontolo.dto.OdontologoFullDto;
import com.example.proyectoBackendOdontolo.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;



import java.util.List;

@SpringBootTest
class OdontologoServiceTest {
@Autowired
private OdontologoService odontologoService;

    @Test
    void agregar() throws ResourceNotFoundException {
        //Arrange
        OdontologoFullDto oDto = new OdontologoFullDto("pepita", "fulana",12365);
        //Act

        OdontologoFullDto result = odontologoService.agregar(oDto);
        //Assert

        assertNotNull(result);
    }
    @Test
    void agregarTestExepciones(){
        //Arrange
        OdontologoFullDto oDto = new OdontologoFullDto();
        try {
            //Act
            OdontologoFullDto result = odontologoService.agregar(oDto);
            //Assert
            fail("Se esperaba excepcion ResourceNotFoundException");

        }catch (ResourceNotFoundException e){}
    }

    @Test
    void buscar() throws ResourceNotFoundException {
        OdontologoFullDto oDto = new OdontologoFullDto("pepita", "fulana",12365);
        OdontologoFullDto oDtoGuardado =  odontologoService.agregar(oDto);
        Integer id = oDtoGuardado.id;
        //Act

        OdontologoDto result = odontologoService.buscar(id);

        //Assert
        assertNotNull(result);

    }

    @Test
    void buscarTestExepciones(){
        //Arrange
        Integer id = null;
        try {
            //Act
            OdontologoDto result = odontologoService.buscar(id);
            //Assert
            fail("Se esperaba excepcion ResourceNotFoundException");

        }catch (ResourceNotFoundException e){}
    }

    @Test
    void eliminar() throws ResourceNotFoundException {

        //Arrange
        OdontologoFullDto dto = new OdontologoFullDto("pepita", "fulana", 1258);
        OdontologoFullDto oGuardado = odontologoService.agregar(dto);
        Integer id = oGuardado.id;
        //Act

        try {
            odontologoService.eliminar(id);
            odontologoService.buscar(id);
            //Assert
            fail("Se esperaba excepcion ResourceNotFoundException");
        } catch(ResourceNotFoundException e) {}

    }

    @Test
    void listar() throws ResourceNotFoundException {
        //Arrange
        OdontologoFullDto dto = new OdontologoFullDto("pepita", "fulana", 1258);
         odontologoService.agregar(dto);
        //Act
       List<OdontologoDto> odontologoDtos = odontologoService.listar();
            //Assert
        assertTrue(odontologoDtos.size()>0);

    }

    @Test
    void modificar() throws ResourceNotFoundException {
        //Arrange
        OdontologoFullDto dto = new OdontologoFullDto("pepita", "fulana", 1258);
        OdontologoDto dto2 = new OdontologoDto("pepita", "fulanita");
        //Act
        OdontologoDto result = odontologoService.modificar(dto.id, dto2);
        //Assert
        assertEquals("fulanita", result.apellido);

    }
}