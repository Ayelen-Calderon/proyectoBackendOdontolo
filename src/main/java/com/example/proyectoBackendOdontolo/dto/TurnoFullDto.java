package com.example.proyectoBackendOdontolo.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TurnoFullDto {
    public  Integer id;
    @NotNull
    public Integer pacienteId;
    @NotNull
    public Integer odontologoId;
    @NotNull
    public LocalDate fecha;

    public TurnoFullDto(Integer pacienteId, Integer odontologoId, LocalDate fecha) {
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
        this.fecha = fecha;
    }

    public TurnoFullDto() {
    }
}
