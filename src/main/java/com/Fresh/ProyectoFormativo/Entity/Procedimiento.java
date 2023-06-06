package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table(name = "procedimientos")
@Data
public class Procedimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificacion_procedimientos")
    private int identificacion_procedimientos;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo")
    private BigInteger costo;
}