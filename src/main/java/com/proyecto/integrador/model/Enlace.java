package com.proyecto.integrador.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="tb_enlace")

public class Enlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idenlace")
	private int codigo;
	private String descripcion;
	private String ruta;

	
	@OneToMany(mappedBy = "enlace")
	private List<RolEnlace> listaRolEnlace;


	


	
}
