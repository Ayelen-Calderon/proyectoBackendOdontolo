package com.example.proyectoBackendOdontolo.service;

import com.example.proyectoBackendOdontolo.dto.TurnoFullDto;
import com.example.proyectoBackendOdontolo.entities.Odontologo;
import com.example.proyectoBackendOdontolo.entities.Paciente;
import com.example.proyectoBackendOdontolo.entities.Turno;
import com.example.proyectoBackendOdontolo.exception.ResourceNotFoundException;
import com.example.proyectoBackendOdontolo.repository.RepositoryTurno;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService  {
    @Autowired
    private RepositoryTurno repositoryTurno;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    ObjectMapper mapper;

    public TurnoService(RepositoryTurno repositoryTurno) {
        this.repositoryTurno = repositoryTurno;
    }


    public  TurnoFullDto guardar(@NotNull TurnoFullDto turnoDto) throws ResourceNotFoundException {

        Paciente paciente = mapper.convertValue(pacienteService.buscar(turnoDto.pacienteId), Paciente.class);
        Odontologo odontologo = mapper.convertValue(odontologoService.buscar(turnoDto.odontologoId), Odontologo.class);
        Turno turnoEntity2 = new Turno(paciente, odontologo, turnoDto.fecha);

        Turno entity = repositoryTurno.save(turnoEntity2);

        TurnoFullDto turnoCreadoDTO = mapper.convertValue(entity, TurnoFullDto.class);

        return turnoCreadoDTO;
    }




    public TurnoFullDto buscar(Integer id) throws ResourceNotFoundException {

        Optional<Turno> turno =  repositoryTurno.findById(id);
        if(!turno.isPresent()){
            throw new ResourceNotFoundException("El turno con id "+id+" no existe");
        }

        return mapper.convertValue(turno, TurnoFullDto.class);



    }


    public void eliminar(Integer id) throws ResourceNotFoundException {

        if(buscar(id) == null){
            throw new ResourceNotFoundException("no exite el turno que desea eliminar");
        }
          repositoryTurno.deleteById(id);
    }


    public List<TurnoFullDto> listar() {


        List<TurnoFullDto> turnosDtos = new ArrayList<>();
        for (int i = 0; i < repositoryTurno.findAll().size() ; i++) {

            Integer id =repositoryTurno.findAll().get(i).getId();
            turnosDtos.add(mapper.convertValue(repositoryTurno.findAll(), TurnoFullDto.class));
        }

        return turnosDtos;

    }



}
