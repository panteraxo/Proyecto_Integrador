package com.proyecto.integrador.service;


import com.proyecto.integrador.model.Opcion;
import com.proyecto.integrador.model.Rol;
import com.proyecto.integrador.model.RolHasOpcion;
import com.proyecto.integrador.model.RolHasOpcionPK;

import java.util.List;
import java.util.Optional;

public interface RolService {
	

	 Rol login(Rol bean);

	 List<Rol> listaRol();

	 List<Opcion> traerOpcionDeRol(int idRol);

	 Optional<RolHasOpcion> buscaOpcion(RolHasOpcionPK ojb);

	 RolHasOpcion insertaOpcion(RolHasOpcion ojb);

	 void eliminaOpcion(RolHasOpcion obj);

	//	 List<String> getRol(int idRol);
	 List<Object> getObjRol(int idRol);
}
