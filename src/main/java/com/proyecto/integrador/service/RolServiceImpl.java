package com.proyecto.integrador.service;

import com.proyecto.integrador.model.Opcion;
import com.proyecto.integrador.model.Rol;
import com.proyecto.integrador.model.RolHasOpcion;
import com.proyecto.integrador.model.RolHasOpcionPK;
import com.proyecto.integrador.repository.RolHasOpcionRepository;
import com.proyecto.integrador.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private RolHasOpcionRepository rolHasOpcionRepository;
	
	@Override
	public List<Rol> listaRol() {
		return rolRepository.findAll();
	}

	@Override
	public List<Opcion> traerOpcionDeRol(int id_rol) {
		return rolRepository.traerOpcionDeRol(id_rol);
	}

	@Override
	public Optional<RolHasOpcion> buscaOpcion(RolHasOpcionPK ojb) {
		 
		return rolHasOpcionRepository.findById(ojb);
	}

	@Override
	public RolHasOpcion insertaOpcion(RolHasOpcion ojb) {
		 
		return rolHasOpcionRepository.save(ojb);
	}

	@Override
	public void eliminaOpcion(RolHasOpcion obj) {
		rolHasOpcionRepository.delete(obj);
		
	}

	@Override
	public Rol login(Rol bean) {
		 
		return rolRepository.login(bean);
	}
	
	@Override
	public List<Object> getObjRol(int id_rol) {
		 
		return rolRepository.getObjRol(id_rol);
	}

}
