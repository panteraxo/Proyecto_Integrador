package com.proyecto.integrador.controller;

import com.proyecto.integrador.model.Opcion;
import com.proyecto.integrador.model.Rol;
import com.proyecto.integrador.model.Usuario;
import com.proyecto.integrador.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;


@Controller
@SessionAttributes({"rolUsuario","ENLACES"})
@RequestMapping
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	/*@GetMapping("/bienvenida")
	public String login(Usuario user, HttpSession session, Model model) {
		Usuario usuario = servicio.login(user.getLogin(), user.getPassword());
		if (usuario == null) {
			model.addAttribute("mensaje", "El usuario no existe");
			return "redirect:/";
		} else {

			usuario.setNombres(usuario.getNombres().substring(0, 1).toUpperCase() + usuario.getNombres().substring(1));
			usuario.setApellidos(
					usuario.getApellidos().substring(0, 1).toUpperCase() + usuario.getApellidos().substring(1));
			List<Rol> roles = servicio.traerRolesDeUsuario(usuario.getIdUsuario());
			List<Opcion> menus = servicio.traerEnlacesDeUsuario(usuario.getIdUsuario());

			session.setAttribute("objUsuario", usuario);
			session.setAttribute("objRoles", roles);

			return "redirect:/bienvenida";
		}
	}*/

	@GetMapping("/bienvenida")
	public String intranet(Authentication auth, Model model) {
		String vLogin=auth.getName();
		System.out.println("Usuario: "+vLogin);
		//invocar al metodo validarSesion
		Usuario bean=usuarioService.validarSesion(vLogin);
		System.out.println("Usuario: "+bean);
		//invocar al metodo enlacesDelUsuario
		List<Opcion> lista=usuarioService.traerEnlacesDeUsuario(bean.getIdUsuario());
		System.out.println("Enlaces: "+lista);
		//asignar valor a los atributos de tipo sesión
		List<Rol> roles = usuarioService.traerRolDeUsuario(bean.getIdUsuario());
		System.out.println("Roles: "+roles);

		List<Opcion> menus = usuarioService.traerEnlacesDeUsuario(bean.getIdUsuario());
		System.out.println("Menus: "+menus);

		model.addAttribute("rolUsuario",roles);
		System.out.println("Rol Usuario: "+roles.toString());
		model.addAttribute("ENLACES",menus);
		System.out.println("Enlaces: "+menus.toString());
		return "bienvenida";
	}

	@GetMapping("/logoutt")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
