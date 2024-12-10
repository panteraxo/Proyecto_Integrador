package com.proyecto.integrador.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="tb_rol_enlace")
@Getter
@Setter
public class RolEnlace {
	
	@EmbeddedId
	private RolEnlacePK id;
	
	@ManyToOne
	@JoinColumn(name = "idrol",insertable = false,updatable = false,referencedColumnName ="idrol")
	private Rol rol;

	
	@ManyToOne
	@JoinColumn(name="idenlace",insertable = false,updatable = false,referencedColumnName = "idenlace")
	private Enlace enlace;
	
	
	
}