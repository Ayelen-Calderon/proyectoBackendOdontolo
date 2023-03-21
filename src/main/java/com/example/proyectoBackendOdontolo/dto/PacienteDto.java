package com.example.proyectoBackendOdontolo.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PacienteDto {
    public Integer id;
    @NotNull
    public String nombre;
    @NotNull
    public String apellido;
    @NotNull
    public String dNI;
    @NotNull
    public String domicilio;

    public PacienteDto(String nombre, String apellido, String dNI, String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dNI = dNI;
        this.domicilio = domicilio;
    }

    public PacienteDto() {
    }
}
