package com.proyecto.integrador.service;



import java.util.List;

import com.proyecto.integrador.model.Cliente;

public interface ClienteService {
    /* Optional<Cliente> obtenerClientePorUsuario(Usuario usuario); no tiene uso*/
    List<Cliente> listarCliente();
    void guardarCliente(Cliente cliente);
    Cliente obtenerClientePorId(Integer id);
    void eliminarClientePorId(Integer id);
    /* void eliminarClientePorUsuarioId(Integer usuarioId); no tiene uso*/
}
