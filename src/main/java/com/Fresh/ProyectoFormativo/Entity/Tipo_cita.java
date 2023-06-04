package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "tipo_cita")
public class Tipo_cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_cita")
    private int id_tipo_cita;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "costo")
    private BigInteger costo;

    public int getId_tipo_cita() {
        return id_tipo_cita;
    }

    public void setId_tipo_cita(int id_tipo_cita) {
        this.id_tipo_cita = id_tipo_cita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getCosto() {
        return costo;
    }

    public void setCosto(BigInteger costo) {
        this.costo = costo;
    }
}