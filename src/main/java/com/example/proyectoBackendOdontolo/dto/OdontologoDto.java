package com.example.proyectoBackendOdontolo.dto;

import javax.validation.constraints.NotNull;

public class OdontologoDto {
    @NotNull
    public String nombre;
    @NotNull
    public String apellido;

    public OdontologoDto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
