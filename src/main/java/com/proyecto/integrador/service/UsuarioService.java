package com.proyecto.integrador.service;

import com.proyecto.integrador.model.Usuario;

public interface UsuarioService {
    Usuario obtenerUsuario(String nombreUsuario, String contrasena);
}
