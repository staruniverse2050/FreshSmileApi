package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
@Table(name = "paciente")
public class Paciente {

    @Id
    @Column(name = "identificacion_paciente")
    private int identificacion_paciente;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "nombre_completo")
    private String nombre_completo;

    @Column(name = "telefono")
    private String  telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "fecha_registro")
    private LocalDateTime fecha_registro;

    @Column(name = "estado")
    private boolean Estado;
}

