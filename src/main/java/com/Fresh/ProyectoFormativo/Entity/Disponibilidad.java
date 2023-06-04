package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "disponibilidad_administrador")
public class Disponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disponibilidad")
    private int id_disponibilidad;

    @Column(name = "id_administrador")
    private int id_administrador;

    @Column(name = "fecha_disponibilidad")
    private String fecha_disponibilidad;

    @Column(name = "horas_disponibles")
    private String horas_disponibles;
    public int getId_disponibilidad() {
        return id_disponibilidad;
    }

    public void setId_disponibilidad(int id_disponibilidad) {
        this.id_disponibilidad = id_disponibilidad;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getFecha_disponibilidad() {
        return fecha_disponibilidad;
    }

    public void setFecha_disponibilidad(String fecha_disponibilidad) {
        this.fecha_disponibilidad = fecha_disponibilidad;
    }

    public String getHoras_disponibles() {
        return horas_disponibles;
    }

    public void setHoras_disponibles(String horas_disponibles) {
        this.horas_disponibles = horas_disponibles;
    }
}
