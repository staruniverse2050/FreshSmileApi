package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "codigo_administrador")
public class Codigo_administrador {
    @Column(name = "codigo")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}