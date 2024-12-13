package com.proyecto.integrador.security;

import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserSecurity implements UserDetailsService{
	@Autowired
	private UsuarioService servicio;
	
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		UserDetails datos=null;
		//invocar al metodo validarSesion
		Usuario bean=servicio.validarSesion(nombreUsuario);
		//rol del usuario
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		//adicionar rol del usuario
		rol.add(new SimpleGrantedAuthority(bean.getRol().getDescripcion()));
		//crear objeto datos
		datos=new User(nombreUsuario,bean.getClave(),rol);
		
		return datos;
	}

}
