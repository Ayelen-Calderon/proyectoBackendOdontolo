package com.example.proyectoBackendOdontolo.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PacienteFullDto {
    public  Integer id;
    @NotNull
    public String nombre;
    @NotNull
    public String apellido;
    @NotNull
    public String dNI;

    public String domicilio;
    @NotNull
    public LocalDate fechaDeAlta;

    public PacienteFullDto(String nombre, String apellido, String dNI, String domicilio, LocalDate fechaDeAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dNI = dNI;
        this.domicilio = domicilio;
        this.fechaDeAlta = fechaDeAlta;
    }

    public PacienteFullDto() {
    }
}


