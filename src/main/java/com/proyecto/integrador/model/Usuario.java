package com.proyecto.integrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.integrador.util.Registros;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="tb_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(unique = true)
	private String login;
	private String password;


	private String nombres;
	private String apellidos;
	private String dni;
	private String correo;
	private String direccion;

	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<UsuarioHasRol> usuarioHasRol;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Lima")
	private Date fechaNacimiento;

	public String getNombreCompleto() {
		return nombres.concat(" ").concat(apellidos);
	}

	@Embedded
	private Registros registros = new Registros();



}
