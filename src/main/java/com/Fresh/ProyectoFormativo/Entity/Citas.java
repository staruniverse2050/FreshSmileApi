package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int id_cita;

    @Column(name = "id_pacientecita")
    private int id_pacientecita;

    @Column(name = "id_administradorcita")
    private int id_administradorcita;

    @Column(name = "id_disponibilidad")
    private int id_disponibilidad;

    @Column(name = "id_tipo_citas")
    private int  id_tipo_citas;
    @Column(name = "estado")
    private String estado;

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_pacientecita() {
        return id_pacientecita;
    }

    public void setId_pacientecita(int id_pacientecita) {
        this.id_pacientecita = id_pacientecita;
    }

    public int getId_administradorcita() {
        return id_administradorcita;
    }

    public void setId_administradorcita(int id_administradorcita) {
        this.id_administradorcita = id_administradorcita;
    }

    public int getId_disponibilidad() {
        return id_disponibilidad;
    }

    public void setId_disponibilidad(int id_disponibilidad) {
        this.id_disponibilidad = id_disponibilidad;
    }

    public int getId_tipo_citas() {
        return id_tipo_citas;
    }

    public void setId_tipo_citas(int id_tipo_citas) {
        this.id_tipo_citas = id_tipo_citas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
