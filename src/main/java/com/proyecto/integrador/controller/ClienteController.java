package com.proyecto.integrador.controller;
import com.proyecto.integrador.model.Cliente;
import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.service.ClienteService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/listarDatos")
    public String listarDatosPersonales(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        clienteService.obtenerClientePorUsuario(usuario).ifPresent(cliente -> model.addAttribute("cliente", cliente));
        return "cliente/datosPersonales";
    }

    @GetMapping("/editarDatos")
    public String mostrarFormularioEditarDatos(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        clienteService.obtenerClientePorUsuario(usuario).ifPresent(cliente -> model.addAttribute("cliente", cliente));
        return "cliente/editarDatosPersonales";
    }

    @PostMapping("/guardarDatos")
    public String guardarDatosPersonales(@ModelAttribute("cliente") Cliente cliente, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        cliente.setUsuario(usuario);
        clienteService.actualizarCliente(cliente);
        return "redirect:/cliente/listarDatos";
    }

    @GetMapping("/eliminarCuenta")
    public String eliminarCuenta(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        clienteService.eliminarClientePorUsuarioId(usuario.getIdUsuario());
        session.invalidate();
        return "redirect:/login";
    }
}
