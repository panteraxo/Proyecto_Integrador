package com.proyecto.integrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.proyecto.integrador.security.VendedorNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(VendedorNotFoundException.class)
    public ResponseEntity<String> handleVendedorNotFoundException(VendedorNotFoundException e){
        return ResponseEntity.notFound().build();
    }
}
