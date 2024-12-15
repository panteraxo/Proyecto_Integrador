package com.proyecto.integrador.model;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class RolHasOpcionPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idRol;
	private int idOpcion;

}
