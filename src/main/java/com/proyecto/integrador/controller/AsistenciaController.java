package com.proyecto.integrador.controller;
import com.proyecto.integrador.model.Asistencia;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.integrador.security.VendedorNotFoundException;
import com.proyecto.integrador.service.AsistenciaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class AsistenciaController {
    
    private final AsistenciaService asistenciaService;

    @GetMapping("/asistencia")
    public String mostrarAsistencia() {
        return "asistencia";
    }
    @GetMapping("/asistencia/listarAsistencia")
    public String mostrarAsistencia(Model model) {
        List<Asistencia> listaAsistencia = asistenciaService.listarAsistencia();
        model.addAttribute("listaAsistencia", listaAsistencia);
        return "asistencia/asistencias";
    }

    @PostMapping("/asistencia/registrar")
    public String registrarAsistencia(@RequestParam("codigo") String codigo,
                                      @RequestParam("tipo") String tipo,
                                      Model model) {
         try {
            String mensaje = asistenciaService.registrarAsistencia(codigo, tipo);
            model.addAttribute("mensaje", mensaje);
        } catch (VendedorNotFoundException e) {
            model.addAttribute("mensaje", "Error: " + e.getMessage());
        } catch (Exception e) {
            model.addAttribute("mensaje", "Error inesperado: " + e.getMessage());
        }
        return "asistencia";
    }
    
}
