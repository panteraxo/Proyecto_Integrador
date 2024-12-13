package com.proyecto.integrador.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.proyecto.integrador.model.Rol;
import com.proyecto.integrador.repository.RolRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;
    @Override
    public List<Rol> listarRol() {
        return rolRepository.findAll();
    }

    @Override
    public void guardarRol(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public Rol obtenerRolPorId(Integer id) {
        return rolRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el Rol con id: " + id));
    }

    @Override
    public void eliminarRol(Integer id) {
        if(rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontro el Rol con id: " + id);
        }
    }
}
