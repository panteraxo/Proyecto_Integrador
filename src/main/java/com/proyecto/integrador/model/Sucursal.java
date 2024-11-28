package com.proyecto.integrador.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_sucursal")
@Getter
@Setter
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sucursal")
    private Integer idSucursal;

    @Column(name="nombreSucursal",length = 100, nullable = false)
    private String nombreSucursal;

    @Column(name="direccion",length = 100, nullable = false)
    private String direccionSucursal;

    @Column(name="ciudad",length = 100, nullable = false)
    private String Ciudad;

    @Column(name="departamento",length = 100, nullable = false)
    private String Departamento;

    @Column(name="provincia",length = 100, nullable = false)
    private String Provincia;

    @Column(name="pais",length = 100, nullable = false)
    private String Pais;
}
