package com.proyecto.integrador.controller;

import com.proyecto.integrador.model.Sucursal;
import com.proyecto.integrador.service.SucursalService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sucursales")
@AllArgsConstructor
public class SucursalController {
    private final SucursalService sucursalService;
    private final EntityManager entityManager;

    @GetMapping("/listarSucursales")
    public String verPaginaInicio(Model model) {
        List<Sucursal> listaSucursales = sucursalService.listarSucursal();
        model.addAttribute("listaSucursales", listaSucursales);
        return "sucursales/sucursales";
    }

    @GetMapping("/nuevaSucursal")
    public String nuevaSucursal(Model model) {
        model.addAttribute("sucursal", new Sucursal());
        return "sucursales/nuevaSucursal";
    }

    @PostMapping("/guardarSucursal")
    public String guardarSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
        sucursalService.guardarSucursal(sucursal);
        return "redirect:/sucursales/listarSucursales";
    }

    @GetMapping("/actualizarSucursal/{id}")
    public String actualizarSucursal(@PathVariable("id") Integer id, Model model) {
        Sucursal sucursal = sucursalService.obtenerSucursalPorId(id);
        model.addAttribute("sucursal", sucursal);
        return "sucursales/actualizarSucursal";
    }

    @GetMapping("/eliminarSucursal/{id}")
    public String eliminarSucursal(@PathVariable("id") Integer id) {
        sucursalService.eliminarSucursal(id);
        return "redirect:/sucursales/listarSucursales";
    }
        @GetMapping("reporteSucursales")
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
