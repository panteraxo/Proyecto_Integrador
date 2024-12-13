package com.proyecto.integrador.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.integrador.model.Asistencia;
import com.proyecto.integrador.model.Vendedor;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    Optional<Asistencia> findByFechaAndVendedor(LocalDate fecha,Vendedor vendedor);
    @Query("SELECT a FROM Asistencia a WHERE a.vendedor.idVendedor = :idVendedor AND MONTH(a.fecha) = :mes AND YEAR(a.fecha) = :anio")
    List<Asistencia> findByVendedorAndMes(@Param("idVendedor") Integer idVendedor, @Param("mes") int mes, @Param("anio") int anio);
} 
