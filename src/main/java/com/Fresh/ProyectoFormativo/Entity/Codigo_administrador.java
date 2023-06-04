package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "codigo_administrador")
public class Codigo_administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_codigo")
    private int id_codigo;
    @Column(name = "codigo")
    private static String codigo;

    public int getId_codigo() {
        return id_codigo;
    }

    public void setId_codigo(int id_codigo) {
        this.id_codigo = id_codigo;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        Codigo_administrador.codigo = codigo;
    }
}