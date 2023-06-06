package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "codigo_administrador")
public class Codigo_administrador {
    @Id
    @Column(name = "codigo")
    private String codigo;
}