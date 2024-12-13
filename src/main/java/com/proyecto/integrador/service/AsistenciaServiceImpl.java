package com.proyecto.integrador.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.proyecto.integrador.model.Asistencia;
import com.proyecto.integrador.model.Vendedor;
import com.proyecto.integrador.repository.AsistenciaRepository;
import com.proyecto.integrador.repository.VendedorRepository;
import com.proyecto.integrador.security.VendedorNotFoundException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsistenciaServiceImpl implements AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final VendedorRepository vendedorRepository;

    private final LocalTime HORA_INICIO = LocalTime.of(8, 0);
    private final LocalTime HORA_FIN = LocalTime.of(17, 0);

    @Override
    public List<Asistencia> listarAsistencia() {
        return asistenciaRepository.findAll();
       
    }

    @Override
    public String registrarAsistencia(String codigo, String tipo) {
        Vendedor vendedor = vendedorRepository.findByCodigo(codigo).orElseThrow(() -> new VendedorNotFoundException("Vendedor no encontrado"));
        
        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        
        Asistencia asistencia = asistenciaRepository.findByFechaAndVendedor(hoy, vendedor).orElse(new Asistencia());

        asistencia.setVendedor(vendedor);
        asistencia.setFecha(hoy);

        if("ingreso".equals(tipo)){
            if (ahora.isBefore(HORA_INICIO)) {
                return "Solo puede marcar ingreso a partir de las 8:00";
            }
            if (asistencia.getHoraEntrada() != null) {
                return "El ingreso ya ha sido registrado.";
            }
            asistencia.setHoraEntrada(ahora);
        }else if ("salida".equals(tipo)) {
            if (asistencia.getHoraEntrada() == null) {
                return "Debe registrar primero el ingreso.";
            }
            if (asistencia.getHoraSalida() != null) {
                return "La salida ya ha sido registrada.";
            }
            asistencia.setHoraSalida(ahora);
    }else {
        return "Tipo no válido.";
    }
    asistenciaRepository.save(asistencia);
        return "Registro exitoso.";

}

    @Override
    public long calcularHorasTotales(int idVendedor, int mes, int anio) {
        List<Asistencia> asistencias = asistenciaRepository.findByVendedorAndMes(idVendedor, mes, anio);
        long totalHoras = 0;

        for (Asistencia asistencia : asistencias) {
            if (asistencia.getHoraEntrada() != null && asistencia.getHoraSalida() != null) {
                Duration duracion = Duration.between(asistencia.getHoraEntrada(), asistencia.getHoraSalida());
                totalHoras += duracion.toHours();
            }
        }

        return totalHoras;  
    }
    
}
