package com.proyecto.integrador.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_vendedor")
@Data
@Getter
@Setter
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vendedor")
    private Integer idVendedor;

    @Column(name="nombreVendedor",length = 50, nullable = false)
    private String nombre;

    @Column(name="apellidoVendedor",length = 100, nullable = false)
    private String apellido;

    @Column(name="correo",length = 100, nullable = false)
    private String email;

    @Column(name="telefono",length = 100, nullable = false)
    private String telefono;

    @Column(name="direccion",length = 100, nullable = false)
    private String direccion;

    @Column(name="salario",scale = 2, nullable = false)
    private BigDecimal salario;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
}
