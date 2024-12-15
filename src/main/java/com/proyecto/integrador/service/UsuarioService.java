package com.proyecto.integrador.service;


import com.proyecto.integrador.model.*;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

	Usuario validarSesion(String vLogin);
	
	/*Usuario login(String login, String password);*/



	List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	List<Rol> traerRolesDeUsuario(int idUsuario);

	Usuario buscaPorLogin(String login);
	Usuario buscarPorCorreo(String correo);
	Usuario registrarUsuario(Usuario user);

	List<Usuario> BuscaPorNombreUsu(String usu);

	// ROL DE USUARIO
	List<Usuario> listaUsuario();

	List<Rol> traerRolDeUsuario(int idUsuario);

	Optional<UsuarioHasRol> buscaRol(UsuarioHasRolPK ojb);

	UsuarioHasRol insertaRol(UsuarioHasRol ojb);

	void eliminaRol(UsuarioHasRol obj);

	List<Object> getObjUsuario(int idUsuario);

	List<Rol> traerRolesPorDni(String dni);
}
