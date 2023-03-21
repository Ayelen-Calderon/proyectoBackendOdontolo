package com.example.proyectoBackendOdontolo.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsGlobal{
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesoExcepcionBadRequest(@NotNull ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
}

}
