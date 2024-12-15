package com.proyecto.integrador.security;

import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("login: "+username);
		UserDetails datos=null;
		//invocar al metodo validarSesion
		Usuario bean=servicio.validarSesion(username);
		System.out.println("bean: "+bean);
		//rol del usuario
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		System.out.println("rol: "+rol);
		//crear objeto datos
		datos=new User(username,bean.getPassword(),rol);
		
		return datos;
	}

}
