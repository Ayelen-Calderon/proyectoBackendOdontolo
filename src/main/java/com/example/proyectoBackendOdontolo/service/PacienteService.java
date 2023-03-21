package com.example.proyectoBackendOdontolo.service;

import com.example.proyectoBackendOdontolo.dto.PacienteDto;
import com.example.proyectoBackendOdontolo.dto.PacienteFullDto;

import com.example.proyectoBackendOdontolo.entities.Paciente;
import com.example.proyectoBackendOdontolo.exception.ResourceNotFoundException;
import com.example.proyectoBackendOdontolo.repository.RepositoryPaciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class PacienteService{

    @Autowired
    RepositoryPaciente repositoryPaciente;
    @Autowired
    ObjectMapper mapper;

    private static final Logger logger = Logger.getLogger(PacienteService.class);

    public PacienteFullDto agregar(PacienteFullDto pacienteFullDto) throws ResourceNotFoundException {
        PacienteFullDto pFD = pacienteFullDto;

        if(pFD.apellido == null || pFD.nombre == null || pFD.dNI == null || pFD.domicilio == null || pFD.fechaDeAlta == null){
            logger.info("se produce una exepcion por ingresar campos vacios al cargar un paciente.");
            throw new ResourceNotFoundException("No se puede agregar paciente, faltan datos");
        }
        Paciente pacienteEntity = mapper.convertValue(pFD , Paciente.class);
        Paciente paciente = repositoryPaciente.save(pacienteEntity);

        return mapper.convertValue(paciente, PacienteFullDto.class);
    }


    public PacienteDto buscar(Integer id) throws ResourceNotFoundException {
       Optional<Paciente> paciente = repositoryPaciente.findById(id);
        if (!paciente.isPresent()) {
            logger.info("se produce una exepcion por ingresar id invalido.");
            throw new ResourceNotFoundException("El paciente con id "+id+" no existe");
        }


        return mapper.convertValue(paciente, PacienteDto.class);
    }


    public void eliminar(Integer id) throws ResourceNotFoundException {
        if (buscar(id) == null) {
            logger.info("se produce una exepcion por ingresar id invalido.");
           throw new ResourceNotFoundException("El paciente con id "+id+" no existe");
        }
        repositoryPaciente.deleteById(id);

    }


    public List<PacienteDto> listar() {

        List<PacienteDto> pacienteDtos = new ArrayList<>();
        for (int i = 0; i < repositoryPaciente.findAll().size() ; i++) {
            Integer id = repositoryPaciente.findAll().get(i).getId();
            pacienteDtos.add(mapper.convertValue(repositoryPaciente.findById(id), PacienteDto.class));
        }

        return pacienteDtos;
    }



    public PacienteDto  modificar(Integer id, PacienteDto pacienteDto) throws ResourceNotFoundException {

        PacienteDto pacienteDto1 = buscar(id);
        Optional<Paciente> pacienteOptional = Optional.ofNullable(mapper.convertValue(pacienteDto1, Paciente.class));


        if (pacienteOptional.isPresent()) {

            pacienteOptional.get().setNombre(pacienteDto.nombre != null ? pacienteDto.nombre : pacienteOptional.get().getNombre());
            pacienteOptional.get().setApellido(pacienteDto.apellido != null ? pacienteDto.apellido : pacienteOptional.get().getApellido());
            pacienteOptional.get().setdNI(pacienteDto.dNI != null ? pacienteDto.dNI: pacienteOptional.get().getdNI());
            pacienteOptional.get().setDomicilio(pacienteDto.domicilio != null ? pacienteDto.domicilio : pacienteOptional.get().getDomicilio());
        }
        repositoryPaciente.save(pacienteOptional.get());

        return mapper.convertValue(pacienteOptional, PacienteDto.class);

    }
}
