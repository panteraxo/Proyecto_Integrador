package com.proyecto.integrador.service;



import java.util.List;

import com.proyecto.integrador.model.Asistencia;

public interface AsistenciaService {
    
    List<Asistencia> listarAsistencia();
    String registrarAsistencia(String codigo,String tipo);
}
