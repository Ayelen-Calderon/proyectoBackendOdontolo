package com.example.proyectoBackendOdontolo.dto;
import javax.validation.constraints.NotNull;
public class OdontologoFullDto {
    public Integer id;
    @NotNull
    public String nombre;
    @NotNull
    public String apellido;
    public Integer matricula;

    public OdontologoFullDto(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public OdontologoFullDto() {
    }
}
