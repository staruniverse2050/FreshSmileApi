package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "codigo_administrador")
@Data
public class Codigo_administrador {
    @Id
    @Column(name = "codigo")
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}