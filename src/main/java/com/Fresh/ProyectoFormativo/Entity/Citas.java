package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @Column(name = "fecha_cita")
    private Date fecha_cita;

    @Column(name = "hora_cita")
    private LocalTime hora_cita;

    @Column(name = "tipo_cita")
    private String tipo_cita;

    @Column(name = "estado")
    private String estado;

    @Column(name = "costo")
    private BigDecimal costo;


    public String getTipo_cita() { return tipo_cita; }
    public void setTipo_cita(String tipo_cita) { this.tipo_cita = tipo_cita; }

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

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public LocalTime getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(LocalTime hora_cita) {
        this.hora_cita = hora_cita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}
