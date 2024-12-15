package com.proyecto.integrador.repository;

import com.proyecto.integrador.model.Opcion;
import com.proyecto.integrador.model.Rol;
import com.proyecto.integrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String login);


	@Query("Select x from Usuario x where x.login = ?1 and x.password = ?2")
	public abstract Usuario login(String login , String password);

	@Query("Select p from Opcion p, RolHasOpcion pr, Rol r, UsuarioHasRol u where  p.idOpcion = pr.opcion.idOpcion and pr.rol.idRol = r.idRol and r.idRol = u.rol.idRol and u.usuario.idUsuario = :var_idUsuario")
	public abstract List<Opcion> traerEnlacesDeUsuario(@Param("var_idUsuario") int idUsuario);

	@Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.idUsuario = :var_idUsuario")
	public abstract List<Rol> traerRolesDeUsuario(@Param("var_idUsuario") int idUsuario);

	@Query("Select x from Usuario  x where x.correo = ?1")
	public abstract Usuario findByCorreo(String correo);

	@Query("Select u.rol, u.usuario from UsuarioHasRol u where u.usuario.idUsuario = ?1")
	public abstract List<Object> getObjUsuario(int idUsuario);

	@Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.dni = :var_dni")
	public abstract List<Rol> traerRolesPorDni(@Param("var_dni") String dni);

	Usuario findByLogin(String login);
}
