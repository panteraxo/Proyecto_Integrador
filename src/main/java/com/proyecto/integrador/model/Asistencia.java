package com.proyecto.integrador.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_asistencia")
@Data
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer idAsistencia;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha; 

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada; 

    @Column(name = "hora_salida")
    private LocalTime horaSalida; 

    @ManyToOne
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Vendedor vendedor;

}
