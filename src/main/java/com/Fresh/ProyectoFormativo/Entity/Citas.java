package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "citas")
@Data
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificacion_citas")
    private int identificacion_citas;

    @Column(name = "numero_documento")
    private int numero_documento;

    @Column(name = "nombre_completo")
    private String nombre_completo;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private Time hora;

    @Column(name = "id_especialista")
    private int id_especialista;

    @Column(name = "id_paciente")
    private int id_paciente;

    @Column(name = "id_procedimiento")
    private int  id_procedimiento;

    @Column(name = "estado_cita")
    private String estado_cita;

}
