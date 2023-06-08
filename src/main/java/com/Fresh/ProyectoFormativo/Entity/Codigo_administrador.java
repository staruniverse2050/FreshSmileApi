package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "codigo_administrador")
@Data
public class Codigo_administrador {
    @Id
    @Column(name = "codigo")
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}