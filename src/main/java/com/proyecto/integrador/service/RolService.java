package com.proyecto.integrador.service;


import java.util.List;

import com.proyecto.integrador.model.Rol;

public interface RolService {
    List<Rol> listarRol();
    void guardarRol(Rol rol);
    Rol obtenerRolPorId(Integer id);
    void eliminarRol(Integer id);
}
