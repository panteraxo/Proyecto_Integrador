package com.proyecto.integrador.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
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


	public String getRuta() {
		return ruta;
	}


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}


	public List<RolEnlace> getListaRolEnlace() {
		return listaRolEnlace;
	}


	public void setListaRolEnlace(List<RolEnlace> listaRolEnlace) {
		this.listaRolEnlace = listaRolEnlace;
	}


	
}
