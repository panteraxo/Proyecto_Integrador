package com.proyecto.integrador.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.repository.UsuarioRepository;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Override
    public Usuario obtenerUsuario(String nombreUsuario, String contrasena) {
        return usuarioRepository.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
    }
}

