package com.proyecto.integrador.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.proyecto.integrador.model.Cliente;
import com.proyecto.integrador.repository.ClienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    /* @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> obtenerClientePorUsuario(Usuario usuario) {
        return clienteRepository.findByUsuario(usuario);
    } */


    /* @Override
    public void eliminarClientePorUsuarioId(Integer usuarioId) {
        clienteRepository.deleteById(usuarioId);
    } */

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el cliente con id: " + id));
    }

    @Override
    public void eliminarClientePorId(Integer id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontro el cliente con id: " + id);
        }
    }
}
