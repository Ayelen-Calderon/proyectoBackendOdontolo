package com.example.proyectoBackendOdontolo.repository.security;
import com.example.proyectoBackendOdontolo.entities.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
   Optional<UserEntity> findByEmail(String email);
}
