package com.proyecto.integrador.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.proyecto.integrador.model.Vendedor;
import com.proyecto.integrador.repository.VendedorRepository;

import java.util.List;
import java.util.UUID;
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
        String codigo = generarCodigoUnico();
        vendedor.setCodigo(codigo);
        vendedorRepository.save(vendedor);
    }

    @Override
    public void editVendedor(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    private String generarCodigoUnico(){
        return UUID.randomUUID().toString();
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
