package com.proyecto.integrador.controller;

import com.proyecto.integrador.model.Enlace;
import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;


@Controller
@SessionAttributes({"datosUsuario","ENLACES","CODIGOUSUARIO"})
@RequestMapping
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/")
    public String mostrarLoginForm() {
        return "login";
    }

    @GetMapping("/bienvenida")
    public String intranet(Authentication auth, Model model) {
        String vLogin=auth.getName();
        //invocar al metodo validarSesion
        Usuario bean=usuarioService.validarSesion(vLogin);
        //invocar al metodo enlacesDelUsuario
        List<Enlace> lista=usuarioService.enlacesDelUsuario(bean.getRol().getCodigo());
        //asignar valor a los atributos de tipo sesión
        model.addAttribute("datosUsuario",bean.getApellido()+
                " "+bean.getNombre());
        model.addAttribute("ENLACES",lista);
        model.addAttribute("CODIGOUSUARIO", bean.getCodigo());
        return "bienvenida";
    }


    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
