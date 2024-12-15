package com.proyecto.integrador.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.service.RolService;
import com.proyecto.integrador.service.UsuarioService;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final EntityManager entityManager;
    private final RolService rolService;
    
    @GetMapping("/listarUsuarios")
    public String verPaginaInicio(Model model) {
        List<Usuario> listaUsuarios = usuarioService.listaUsuario();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "usuarios/usuarios";
    }

    @GetMapping("/nuevoUsuario")
    public String nuevoUsuario(Model model) {
        model.addAttribute("listaRoles", rolService.listaRol());
        model.addAttribute("usuario", new Usuario());
        
        return "usuarios/nuevoUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarSucursal(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/usuarios/listarUsuarios";
    }

    /*@GetMapping("/actualizarUsuario/{id}")
    public String actualizarSucursal(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuarios/actualizarUsuario";
    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios/listarUsuarios";
    }*/

    @GetMapping("reporteUsuarios")
    public void reporteVendedores(HttpServletResponse response) throws JRException, SQLException, IOException {
        // Obtén la conexión JDBC desde el EntityManager
        Session session = entityManager.unwrap(Session.class);
        Connection conn = session.doReturningWork(connection -> connection.unwrap(Connection.class));

        // Cargar el reporte .jasper
        InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptSucursales.jasper");
        Map<String, Object> params = new HashMap<>();

        // Cargar el reporte
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

        // Llenar el reporte con la conexión JDBC obtenida
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

        // Configuración para devolver el reporte PDF en la respuesta HTTP
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=sucursales_report.pdf");

        // Enviar el reporte como respuesta
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        // Cerrar la conexión
        conn.close();

    }
}
