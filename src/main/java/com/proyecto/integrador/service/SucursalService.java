package com.proyecto.integrador.service;


import java.util.List;

import com.proyecto.integrador.model.Sucursal;

public interface SucursalService {
    List<Sucursal> listarSucursal();
    void guardarSucursal(Sucursal sucursal);
    Sucursal obtenerSucursalPorId(Integer id);
    void eliminarSucursal(Integer id);
}
