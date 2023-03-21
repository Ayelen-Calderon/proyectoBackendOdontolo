package com.example.proyectoBackendOdontolo.entities;

import javax.persistence.*;

import java.time.LocalDate;
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String dNI;
    @Column
    private String domicilio;
    @Column
    private LocalDate fechaDeAlta;

    public Paciente(String nombre, String apellido, String dNI, String domicilio, LocalDate fechaDeAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dNI = dNI;
        this.domicilio = domicilio;
        this.fechaDeAlta = fechaDeAlta;
    }

    public Paciente() {
    }


    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getdNI() {
        return dNI;
    }

    public void setdNI(String dNI) {
        this.dNI = dNI;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }
}
