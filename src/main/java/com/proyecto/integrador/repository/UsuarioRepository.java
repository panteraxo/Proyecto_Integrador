package com.proyecto.integrador.repository;

import com.proyecto.integrador.model.Enlace;
import com.proyecto.integrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	//select *from tb_usuario where login='aaa' and password='bb'
	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String login);
	
	//select e.idenlace,e.descripcion,e.ruta from tb_rol_enlace re join
	//tb_enlace e on re.idenlace=e.idenlace where re.idrol=1;
	@Query("select e from RolEnlace re join re.enlace e where re.rol.codigo=?1")
	public List<Enlace> traerEnlacesDelUsuario(int codRol);
}








