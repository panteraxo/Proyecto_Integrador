package com.proyecto.integrador.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="tb_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usu")
	private int codigo;

	@Column(unique = true)
	private String login;
	@Column(name = "password")
	private String clave;
	private String nombre;
	private String apellido;
	
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;


	
	
}
