package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "especialista")
public class Especialista {
    @Id
    @Column(name = "identificacion_especialista")
    private int identificacion_especialista;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "nombre_completo")
    private String nombre_completo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "foto_perfil")
    private String foto_perfil;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "fecha_registro")
    private LocalDateTime fecha_registro;
}
