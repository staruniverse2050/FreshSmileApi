package com.Fresh.ProyectoFormativo.Documents;

import lombok.AllArgsConstructor;

public class Comentarios {
    public Comentarios(String Comentario, String NombreUsuario) {
        this.Comentario = Comentario;
        this.NombreUsuario = NombreUsuario;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    private String Comentario;
    private String NombreUsuario;
}
