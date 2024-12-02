package com.proyecto.integrador.controller;
import com.proyecto.integrador.model.Cliente;
import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.service.ClienteService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    /* @GetMapping("/listarDatos")
    public String listarDatosPersonales(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        clienteService.obtenerClientePorUsuario(usuario).ifPresent(cliente -> model.addAttribute("cliente", cliente));
        return "clientes/clientes";
    } */

    @GetMapping("/listarClientes")
    public String listarClientes(Model model,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("datosUsuario");
        if (usuario == null) {
            return "redirect:/";
        }
        List<Cliente> listaClientes = clienteService.listarCliente();
        model.addAttribute("listaClientes", listaClientes);
        return "clientes/clientes";
    }
    @GetMapping("/actualizarCliente/{id}")
    public String actualizarCliente(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cliente", clienteService.obtenerClientePorId(id));
        return "clientes/actualizarCliente";
    }
    /* @GetMapping("/editarDatos")
    public String mostrarFormularioEditarDatos(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        clienteService.obtenerClientePorUsuario(usuario).ifPresent(cliente -> model.addAttribute("cliente", cliente));
        return "clientes/actualizarCliente";
    } */

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/nuevoCliente";
    }
    
    @PostMapping("/guardarDatos")
    public String guardarDatosPersonales(@ModelAttribute("cliente") Cliente cliente, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("datosUsuario");
        if (usuario == null) {
            return "redirect:/";
        }
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes/listarClientes";
    }
    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id) {
        clienteService.eliminarClientePorId(id);
        return "redirect:/clientes/listarClientes";
    }
    /* @GetMapping("/eliminarCuenta")
    public String eliminarCuenta(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        clienteService.eliminarClientePorUsuarioId(usuario.getIdUsuario());
        session.invalidate();
        return "redirect:/";
    } */
    
}
