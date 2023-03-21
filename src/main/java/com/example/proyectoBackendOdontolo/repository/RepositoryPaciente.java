package com.example.proyectoBackendOdontolo.repository;

import com.example.proyectoBackendOdontolo.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepositoryPaciente extends JpaRepository<Paciente, Integer> {
}
