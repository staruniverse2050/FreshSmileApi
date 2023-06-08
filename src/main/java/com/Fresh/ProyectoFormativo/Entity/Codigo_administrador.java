package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "codigo_administrador")
public class Codigo_administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}