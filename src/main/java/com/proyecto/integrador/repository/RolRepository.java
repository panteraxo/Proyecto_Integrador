package com.proyecto.integrador.repository;

import com.proyecto.integrador.model.Opcion;
import com.proyecto.integrador.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Integer>{

	//@Query("Select x from Rol x where x.login = :#{#rol.login} and x.password = :#{#rol.password}")
	@Query("Select x from Rol x where x.nombre = :#{#rol.nombre}")
	Rol login(@Param(value ="rol") Rol bean);

	@Query("Select u.opcion from RolHasOpcion u where u.rol.idRol = ?1")
	List<Opcion> traerOpcionDeRol(int idRol);

	@Query("Select u.opcion, u.rol from RolHasOpcion u where u.rol.idRol = ?1")
	List<Object> getObjRol(int idRol);
}
