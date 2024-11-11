package com.proyecto.integrador.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.integrador.model.Cliente;
import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.repository.ClienteRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> obtenerClientePorUsuario(Usuario usuario) {
        return clienteRepository.findByUsuario(usuario);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void eliminarClientePorUsuarioId(Integer usuarioId) {
        clienteRepository.deleteById(usuarioId);
    }
}
