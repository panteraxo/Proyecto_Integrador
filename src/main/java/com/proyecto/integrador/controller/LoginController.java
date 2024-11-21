package com.proyecto.integrador.controller;

import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping
@RequiredArgsConstructor
@SessionAttributes("usuario")
public class LoginController {

    private final UsuarioService usuarioService;

    @GetMapping(value = "/")
    public String mostrarLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login (@RequestParam("nombreUsuario") String nombreUsuario,
                         @RequestParam("contrasena") String contrasena,
                         Model model){
        Usuario usuario = usuarioService.obtenerUsuario(nombreUsuario, contrasena);
        if(usuario == null){
            model.addAttribute("mensaje","Usuario y/o Contaseña incorrectos");
            return "login";
        }
        model.addAttribute("usuario", usuario);
        return "bienvenida";
    }


    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:";
    }
}
