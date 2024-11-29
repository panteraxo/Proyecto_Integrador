package com.proyecto.integrador.service;

import com.proyecto.integrador.model.Enlace;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.repository.UsuarioRepository;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario validarSesion(String vLogin) {
        return usuarioRepository.iniciarSesion(vLogin);
    }

    public List<Enlace> enlacesDelUsuario(int codRol){
        return usuarioRepository.traerEnlacesDelUsuario(codRol);
    }
    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el sucursal con id: " + id));
    }

    @Override
    public void eliminarUsuario(Integer id) {
        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontro el sucursal con id: " + id);
        }
    }
}

