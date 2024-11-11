package com.proyecto.integrador.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.proyecto.integrador.model.Vendedor;
import com.proyecto.integrador.repository.VendedorRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class    VendedorServiceImpl implements VendedorService {
    private final VendedorRepository vendedorRepository;

    @Override
    public List<Vendedor> listarVendedor() {
        return vendedorRepository.findAll();
    }

    @Override
    public void guardarVendedor(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor obtenerVendedorPorId(Integer id) {
        return vendedorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe el vendedor con el id: " + id));
    }

    @Override
    public void eliminarVendedor(Integer id) {
            if(vendedorRepository.existsById(id)) {
                vendedorRepository.deleteById(id);
            } else {
                throw new RuntimeException("No existe el vendedor con el id: " + id);
            }
    }
}
