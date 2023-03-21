package com.example.proyectoBackendOdontolo.service;

import com.example.proyectoBackendOdontolo.dto.OdontologoDto;
import com.example.proyectoBackendOdontolo.dto.OdontologoFullDto;
import com.example.proyectoBackendOdontolo.entities.Odontologo;
import com.example.proyectoBackendOdontolo.exception.ResourceNotFoundException;
import com.example.proyectoBackendOdontolo.repository.RepositoryOdontologo;
import com.example.proyectoBackendOdontolo.repository.RepositoryTurno;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private RepositoryOdontologo repositoryOdontologo;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    private RepositoryTurno repositoryTurno;
    private static final Logger logger = Logger.getLogger(OdontologoService.class);

    public OdontologoFullDto agregar(@NotNull OdontologoFullDto odontologoDto) throws ResourceNotFoundException {
        if(odontologoDto.apellido == null || odontologoDto.nombre == null || odontologoDto.matricula == null){
            logger.info("se produce una exepcion por ingresar campos vacios al querer carrgar un odontologo.");
            throw  new ResourceNotFoundException("No se puede agregar odontologo con campos vacios");
        }
        Odontologo odontologoEntity = mapper.convertValue(odontologoDto, Odontologo.class);
        Odontologo odontologoCreadoEntity = repositoryOdontologo.save(odontologoEntity);

        return mapper.convertValue(odontologoCreadoEntity, OdontologoFullDto.class );

    }


    public OdontologoDto buscar(Integer id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo = repositoryOdontologo.findById(id);
        if(!odontologo.isPresent()){
            logger.info("se produce una exepcion por ingresar id invalido.");

            throw new ResourceNotFoundException("El odontologo con id "+id+" no existe");
        }

        return mapper.convertValue(odontologo, OdontologoDto.class);
    }


    public void eliminar(Integer id) throws ResourceNotFoundException {
        if (buscar(id) == null){
            logger.info("se produce una exepcion por ingresar id invalido.");
            throw new ResourceNotFoundException("El odontologo con id "+id+" no existe");
        }
        repositoryOdontologo.deleteById(id);
    }


    public List<OdontologoDto> listar() {
        List<OdontologoDto> odontologoDtos = new ArrayList<>();
        for (int i = 0; i < repositoryOdontologo.findAll().size() ; i++) {

            Integer id = repositoryOdontologo.findAll().get(i).getId();
            odontologoDtos.add(mapper.convertValue(repositoryOdontologo.findById(id), OdontologoDto.class));
        }

           return odontologoDtos;
    }


    public OdontologoDto  modificar(Integer id, OdontologoDto odontologoDto) throws ResourceNotFoundException {

               OdontologoDto odontologoDto1 = buscar(id);
                Optional<Odontologo> odontologoOptional = Optional.ofNullable(mapper.convertValue(odontologoDto1, Odontologo.class));


            if (odontologoOptional.isPresent()) {

                odontologoOptional.get().setNombre(odontologoDto.nombre != null ? odontologoDto.nombre : odontologoOptional.get().getNombre());
                odontologoOptional.get().setApellido(odontologoDto.apellido != null ? odontologoDto.apellido : odontologoOptional.get().getApellido());
            }
                   repositoryOdontologo.save(odontologoOptional.get());

        return mapper.convertValue(odontologoOptional, OdontologoDto.class);

    }

}

