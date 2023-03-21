package com.example.proyectoBackendOdontolo.repository;

import com.example.proyectoBackendOdontolo.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepositoryOdontologo extends JpaRepository<Odontologo, Integer> {
}
