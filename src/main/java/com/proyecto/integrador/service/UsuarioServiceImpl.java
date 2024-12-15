package com.proyecto.integrador.service;

import com.proyecto.integrador.model.*;
import com.proyecto.integrador.repository.UsuarioHasRolRepository;
import com.proyecto.integrador.repository.UsuarioRepository;
import com.proyecto.integrador.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioHasRolRepository usuarioHasRolRepository;
    @Autowired
    private BCryptPasswordEncoder encriptar;

	public Usuario validarSesion(String vLogin) {
		return repository.iniciarSesion(vLogin);
	}

	@Override
	public List<Opcion> traerEnlacesDeUsuario(int id_usuario) {
		return repository.traerEnlacesDeUsuario(id_usuario);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int id_usuario) {
		return repository.traerRolesDeUsuario(id_usuario);
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		return repository.findByLogin(login);
	}

	@Override
	public Usuario buscarPorCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

	@Override
	public Usuario registrarUsuario(Usuario bean) {
		// Guardar el Usuario
		bean.setPassword(encriptar.encode(bean.getPassword()));
		Usuario objSalida = repository.save(bean);

		int id_rol = AppSettings.ROL_USUARIO;

		// Configurar UsuarioHasRolPK
		UsuarioHasRolPK hasRolPK = new UsuarioHasRolPK();
		hasRolPK.setIdUsuario(objSalida.getIdUsuario());
		hasRolPK.setIdRol(id_rol);

		// Crear y guardar UsuarioHasRol
		UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
		usuarioHasRol.setUsuarioHasRolPk(hasRolPK);
		usuarioHasRolRepository.save(usuarioHasRol);

		return objSalida;
	}

	@Override
	public List<Usuario> BuscaPorNombreUsu(String usu) {
		return repository.findAll();
	}



	// ROL DE USUARIO

	@Override
	public List<Usuario> listaUsuario() {
		return repository.findAll();
	}

	@Override
	public List<Rol> traerRolDeUsuario(int id_usuario) {
		return repository.traerRolesDeUsuario(id_usuario);
	}

	@Override
	public Optional<UsuarioHasRol> buscaRol(UsuarioHasRolPK ojb) {
		return usuarioHasRolRepository.findById(ojb);
	}

	@Override
	public UsuarioHasRol insertaRol(UsuarioHasRol ojb) {
		return usuarioHasRolRepository.save(ojb);
	}

	@Override
	public void eliminaRol(UsuarioHasRol obj) {
		usuarioHasRolRepository.delete(obj);
	}

	@Override
	public List<Object> getObjUsuario(int id_usuario) {
		return repository.getObjUsuario(id_usuario);
	}

	@Override
	public List<Rol> traerRolesPorDni(String dni) {
		return repository.traerRolesPorDni(dni);
	}

}
