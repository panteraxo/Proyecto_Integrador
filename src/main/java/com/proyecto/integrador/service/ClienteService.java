package com.proyecto.integrador.service;



import java.util.Optional;

import com.proyecto.integrador.model.Cliente;
import com.proyecto.integrador.model.Usuario;

public interface ClienteService {
    Optional<Cliente> obtenerClientePorUsuario(Usuario usuario); 
    void actualizarCliente(Cliente cliente);
    void eliminarClientePorUsuarioId(Integer usuarioId);
}
