package com.proyecto.integrador.controller;

import com.proyecto.integrador.model.Vendedor;
import com.proyecto.integrador.service.SucursalService;
import com.proyecto.integrador.service.VendedorService;
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
import java.util.Map;


@Controller
@RequestMapping("/vendedores")
@AllArgsConstructor
public class VendedorController {
    VendedorService vendedorService;
    EntityManager entityManager;
    SucursalService sucursalService;

    @GetMapping("/listarVendedores")
    public String verPaginaInicio(Model model) {
        model.addAttribute("listaVendedores", vendedorService.listarVendedor());
        return "vendedores/vendedores";

    }
    @GetMapping("/nuevoVendedor")
    public String nuevoVendedor(Model model) {
        model.addAttribute("listaSucursales", sucursalService.listarSucursal());
        model.addAttribute("vendedor", new Vendedor());
        return "vendedores/nuevoVendedor";
    }

    @PostMapping("/guardarVendedor")
    public String guardarVendedor(@ModelAttribute("vendedor") Vendedor vendedor) {
        vendedorService.guardarVendedor(vendedor);
        return "redirect:/vendedores/listarVendedores";
    }

    @GetMapping("/actualizarVendedor/{id}")
    public String actualizarVendedor(@PathVariable("id") Integer id,Model model ) {
        /*model.addAttribute("vendedor", vendedorService.obtenerVendedorPorId(id));*/

        Vendedor vendedor = vendedorService.obtenerVendedorPorId(id);
        vendedor.setSucursal(vendedor.getSucursal());
        model.addAttribute("vendedor", vendedor);

        model.addAttribute("listaSucursales", sucursalService.listarSucursal());

        return "vendedores/actualizarVendedor";
    }

    @GetMapping("/eliminarVendedor/{id}")
    public String eliminarVendedor(@PathVariable("id") Integer id) {
        vendedorService.eliminarVendedor(id);
        return "redirect:/vendedores/listarVendedores";
    }

    @GetMapping("reporteVendedores")
    public void reporteVendedores(HttpServletResponse response) throws JRException, SQLException, IOException {
        // Obtén la conexión JDBC desde el EntityManager
        Session session = entityManager.unwrap(Session.class);
        Connection conn = session.doReturningWork(connection -> connection.unwrap(Connection.class));

        // Cargar el reporte .jasper
        InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptVendedores.jasper");
        Map<String, Object> params = new HashMap<>();

        // Cargar el reporte
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

        // Llenar el reporte con la conexión JDBC obtenida
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

        // Configuración para devolver el reporte PDF en la respuesta HTTP
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=productos_report.pdf");

        // Enviar el reporte como respuesta
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        // Cerrar la conexión
        conn.close();

    }
}
