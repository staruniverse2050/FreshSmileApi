package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "procedimientos")
@Data
public class Procedimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificacion_procedimientos")
    private int identificacion_procedimientos;

    @Column(name="identificacion_especialista")
    private int identificacion_especialista;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo")
    private BigDecimal costo;


    public int getIdentificacion_especialista() {
        return identificacion_especialista;
    }

    public void setIdentificacion_especialista(int identificacion_especialista) {
        this.identificacion_especialista = identificacion_especialista;
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