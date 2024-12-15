package com.proyecto.integrador.controller;

import com.proyecto.integrador.model.Opcion;
import com.proyecto.integrador.model.Rol;
import com.proyecto.integrador.model.RolHasOpcion;
import com.proyecto.integrador.model.RolHasOpcionPK;
import com.proyecto.integrador.service.OpcionService;
import com.proyecto.integrador.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class OpcionRolController {

	@Autowired
	private RolService rolService;

	@Autowired
	private OpcionService opcionService;

	@ResponseBody
	@GetMapping("/listaRol")
	public List<Rol> listaRol() {
		return rolService.listaRol();
	}

	@ResponseBody
	@GetMapping("/listaOpcion")
	public List<Opcion> listaOpcion() {
		return opcionService.listaOpcion();
	}

	@ResponseBody
	@GetMapping("/listaOpcionPorRol")
	public List<Opcion> listaOpcionPorRol(int idRol) {
		return rolService.traerOpcionDeRol(idRol);
	}

	@ResponseBody
	@PostMapping("/registraOpcion")
	public HashMap<String, Object> registro(int idRol, int idOpcion) {
		HashMap<String, Object> maps = new HashMap<String, Object>();
		RolHasOpcionPK pk = new RolHasOpcionPK();
		pk.setIdOpcion(idOpcion);
		pk.setIdRol(idRol);

		RolHasOpcion obj = new RolHasOpcion();
		obj.setRolHasOpcionPK(pk);

		Optional<RolHasOpcion> existenOpcion = rolService.buscaOpcion(pk);
		if (existenOpcion.isEmpty()) {
			RolHasOpcion objSalida = rolService.insertaOpcion(obj);
			if (objSalida == null) {
				maps.put("mensaje", "Error en el registro");
			} else {
				maps.put("mensaje", "Registro existoso");
			}
		} else {
			maps.put("mensaje", "Ya existe la opción");
		}
		//List<Opcion> lstOpcion = rolService.traerOpcionDeRol(idRol);
		List<Object> lstOpcion = rolService.getObjRol(idRol);
		maps.put("lista", lstOpcion);
		maps.put("rol", idRol);
		return maps;
	}

	@ResponseBody
	@PostMapping("/eliminaOpcion")
	public HashMap<String, Object> elimina(int idRol, int idOpcion) {
		HashMap<String, Object> maps = new HashMap<String, Object>();

		RolHasOpcionPK pk = new RolHasOpcionPK();
		pk.setIdOpcion(idOpcion);
		pk.setIdRol(idRol);

		RolHasOpcion obj = new RolHasOpcion();
		obj.setRolHasOpcionPK(pk);

		rolService.eliminaOpcion(obj);
		maps.put("mensaje", "Eliminación exitosa");

		//List<Opcion> lstOpcion = rolService.traerOpcionDeRol(idRol);
		List<Object> lstOpcion = rolService.getObjRol(idRol);
		maps.put("lista", lstOpcion);
		maps.put("rol", idRol);
		return maps;
	}

	// Rol y Opcion
	@ResponseBody
	@GetMapping("/getRolListObj")
	public List<Object> getRolListObj(int idRol) {
		List<Object> listObjRol = rolService.getObjRol(idRol);
		return listObjRol;
	}
	
}