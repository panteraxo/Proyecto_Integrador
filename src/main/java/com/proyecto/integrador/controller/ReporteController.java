/* package com.proyecto.integrador.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.integrador.model.Asistencia;
import com.proyecto.integrador.model.Vendedor;
import com.proyecto.integrador.service.AsistenciaService;

@RestController
@RequeastMapping("/reporte")
public class ReporteController {
    
    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping("/horas-trabajadas")
    public long obtenerHorasTrabajadas(@RequestParam int idVendedor, @RequestParam int mes, @RequestParam int anio){
        return asistenciaService.calcularHorasTotales(idVendedor, mes, anio);
    }
    @GetMapping("/total-horas-trabajadas")
    public List<Map<String, Object>> obtenerTotalHorasTrabajadas() {
        return asistenciaService.listarAsistencia().stream()
                .collect(Collectors.groupingBy(Asistencia::getVendedor))
                .entrySet().stream()
                .map(entry -> {
                    Vendedor vendedor = entry.getKey();
                    long totalHoras = entry.getValue().stream()
                            .filter(asistencia -> asistencia.getHoraEntrada() != null && asistencia.getHoraSalida() != null)
                            .mapToLong(asistencia -> Duration.between(asistencia.getHoraEntrada(), asistencia.getHoraSalida()).toHours())
                            .sum();
                    return Map.of(
                            "vendedor", vendedor.getNombre() + " " + vendedor.getApellido(),
                            "codigo", vendedor.getCodigo(),
                            "totalHoras", totalHoras
                    );
                })
                .collect(Collectors.toList());
    }
}
 */