package com.proyecto.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="tb_rol")
@Getter
@Setter
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
	
	
	
}
