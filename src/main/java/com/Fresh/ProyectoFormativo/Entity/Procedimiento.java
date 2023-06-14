package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "procedimientos")
public class Procedimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificacion_procedimientos")
    private int identificacion_procedimientos;

    @Column(name="identificacion_especialistas")
    private int identificacion_especialistas;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo")
    private BigDecimal costo;


    public int getIdentificacion_especialistas() {
        return identificacion_especialistas;
    }

    public void setIdentificacion_especialistas(int identificacion_especialistas) {
        this.identificacion_especialistas = identificacion_especialistas;
    }

    public int getIdentificacion_procedimientos() {
        return identificacion_procedimientos;
    }

    public void setIdentificacion_procedimientos(int identificacion_procedimientos) {
        this.identificacion_procedimientos = identificacion_procedimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }


}
