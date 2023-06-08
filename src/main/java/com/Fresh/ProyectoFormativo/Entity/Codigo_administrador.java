package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "codigo_administrador")
public class Codigo_administrador {
    @Column(name = "codigo", nullable = false)
    private String codigo;
}
