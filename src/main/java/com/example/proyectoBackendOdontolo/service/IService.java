package com.example.proyectoBackendOdontolo.service;
import java.util.List;
import java.util.Optional;

public interface IService <T>{

    T agregar(T t);

    Optional <T> buscar(Integer id);

    void eliminar(Integer id);

    List<T> listar();

    T modificar(T t);

}
