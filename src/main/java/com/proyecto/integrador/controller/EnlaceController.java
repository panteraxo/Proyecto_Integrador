package com.proyecto.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnlaceController {

	@GetMapping("/")
	public String Inicio() {
		return "login";
	}

	@GetMapping("/home")
	public String Home() {
		return "bienvenida";
	}

	@GetMapping("/Vendedores")
	public String Vendedores() {
		return "vendedores/vendedores";
	}
	// ADMIN
	@GetMapping("/AsignacionRol")
	public String AsignacionRol() {
		return "roles/roles";
	}

	@GetMapping("/AsignacionOpcion")
	public String AsignacionOpcion() {
		return "roles/enlaces";
	}

	@GetMapping("/Usuarios")
	public String Usuarios() {
		return "usuarios/usuarios";
	}
	// ADMIN
	@GetMapping("/Sucursales")
	public String Sucursales() {
		return "sucursales/sucursales";
	}

	@GetMapping("/Asistencia")
	public String Asistencia() {
		return "asistencia/asistencias";
	}

	@GetMapping("/MarcarAsistencia")
	public String MarcarAsistencia() {
		return "asistencia";
	}

	@GetMapping("/Clientes")
	public String Clientes() {
		return "clientes/clientes";
	}

}
