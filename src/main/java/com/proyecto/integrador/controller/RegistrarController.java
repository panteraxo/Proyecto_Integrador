package com.proyecto.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.service.UsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class RegistrarController {
    private final UsuarioService usuarioService;
    
    @PostMapping("login/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario,Model model) {
        if(usuarioService.obtenerUsuarioPorNombre(usuario.getNombreUsuario())) {
            model.addAttribute("mensaje", "El usuario ya existe");
            return "login";
        }
        usuarioService.guardarUsuario(usuario);
        return "redirect:/";   
    }

}
