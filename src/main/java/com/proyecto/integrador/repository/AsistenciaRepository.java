package com.proyecto.integrador.repository;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.integrador.model.Asistencia;
import com.proyecto.integrador.model.Vendedor;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    Optional<Asistencia> findByFechaAndVendedor(LocalDate fecha,Vendedor vendedor);
} 
