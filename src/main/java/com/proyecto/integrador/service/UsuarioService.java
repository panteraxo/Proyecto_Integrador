package com.proyecto.integrador.service;

import java.util.List;

import com.proyecto.integrador.model.Usuario;

public interface UsuarioService {
    Usuario obtenerUsuario(String nombreUsuario, String contrasena);

    List<Usuario> listarUsuario();
    void guardarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Integer id);
    void eliminarUsuario(Integer id);
}
