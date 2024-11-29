package com.proyecto.integrador.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.integrador.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

}

