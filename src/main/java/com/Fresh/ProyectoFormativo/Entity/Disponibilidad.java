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

    @Column(name = "fechas_disponibilidad")
    private String fechas_disponibilidad;

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

    public String getFechas_disponibilidad() {
        return fechas_disponibilidad;
    }

    public void setFechas_disponibilidad(String fechas_disponibilidad) {
        this.fechas_disponibilidad = fechas_disponibilidad;
    }

    public String getHoras_disponibles() {
        return horas_disponibles;
    }

    public void setHoras_disponibles(String horas_disponibles) {
        this.horas_disponibles = horas_disponibles;
    }
}
