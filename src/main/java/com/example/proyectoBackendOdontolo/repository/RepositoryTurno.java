package com.example.proyectoBackendOdontolo.repository;

import com.example.proyectoBackendOdontolo.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepositoryTurno extends JpaRepository<Turno, Integer> {
}
