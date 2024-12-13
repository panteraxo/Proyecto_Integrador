package com.proyecto.integrador.security;

public class VendedorNotFoundException extends RuntimeException {
    public VendedorNotFoundException(String message) {
        super(message);
    }
    
}
