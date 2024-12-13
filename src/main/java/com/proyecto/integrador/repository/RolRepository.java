package com.proyecto.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.integrador.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
