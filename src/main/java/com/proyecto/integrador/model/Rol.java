package com.proyecto.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol")
	private int codigo;
	private String descripcion;
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<Usuario> listaUsuario;
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<RolEnlace> listaRolEnlace;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<RolEnlace> getListaRolEnlace() {
		return listaRolEnlace;
	}

	public void setListaRolEnlace(List<RolEnlace> listaRolEnlace) {
		this.listaRolEnlace = listaRolEnlace;
	}
	
	
	
}
