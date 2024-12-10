package com.proyecto.integrador.service;


import java.util.List;

import com.proyecto.integrador.model.Vendedor;

public interface VendedorService {
    List<Vendedor> listarVendedor();
    void guardarVendedor(Vendedor vendedor);
    void editVendedor(Vendedor vendedor);
    Vendedor obtenerVendedorPorId(Integer id);
    void eliminarVendedor(Integer id);
}
