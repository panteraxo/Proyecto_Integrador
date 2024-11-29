package com.proyecto.integrador.service;

import java.util.List;

import com.proyecto.integrador.model.Enlace;
import com.proyecto.integrador.model.Usuario;

public interface UsuarioService {

    Usuario validarSesion(String vLogin);
    List<Enlace> enlacesDelUsuario(int codRol);;
    Usuario obtenerUsuario(String nombreUsuario, String contrasena);
    boolean obtenerUsuarioPorNombre(String nombreUsuario);
    List<Usuario> listarUsuario();
    void guardarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Integer id);
    void eliminarUsuario(Integer id);
}
