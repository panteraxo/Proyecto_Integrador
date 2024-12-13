package com.proyecto.integrador.controller;
import com.proyecto.integrador.model.Rol;
import com.proyecto.integrador.service.RolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/roles")
@AllArgsConstructor
public class RolController {
    private final RolService RolService;
    @GetMapping("/listarRoles")
    public String verPaginaInicio(Model model) {
        List<Rol> listaRoles = RolService.listarRol();
        model.addAttribute("listaRoles", listaRoles);
        return "Roles/Roles";
    }

    @GetMapping("/nuevaRol")
    public String nuevaRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "Roles/nuevaRol";
    }

    @PostMapping("/guardarRol")
    public String guardarRol(@ModelAttribute("rol") Rol Rol) {
        RolService.guardarRol(Rol);
        return "redirect:/roles/listarRoles";
    }

    @GetMapping("/actualizarRol/{id}")
    public String actualizarRol(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("Rol", RolService.obtenerRolPorId(id));
        return "Roles/actualizarRol";
    }
    

    @GetMapping("/eliminarRol/{id}")
    public String eliminarRol(@PathVariable("id") Integer id) {
        RolService.eliminarRol(id);
        return "redirect:/Roles/listarRoles";
    }
        
}
