package com.Fresh.ProyectoFormativo.Documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document("Especialistas")
public class Especialistas {
    public Especialistas(String nombre, Number edad, String correo, String telefono, String años_Experiencia, String especialidad, Double valoracion, String id, Integer numeroVotaciones, List<com.Fresh.ProyectoFormativo.Documents.Comentarios> comentarios) {
        super();
        Nombre = nombre;
        Edad = edad;
        Correo = correo;
        Telefono = telefono;
        Años_Experiencia = años_Experiencia;
        Especialidad = especialidad;
        Valoracion = valoracion;
        this._id = id;
        this.numeroVotaciones = numeroVotaciones;
        Comentarios = comentarios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    private String Nombre;

    public Number getEdad() {
        return Edad;
    }

    public void setEdad(Number edad) {
        Edad = edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getAños_Experiencia() {
        return Años_Experiencia;
    }

    public void setAños_Experiencia(String años_Experiencia) {
        Años_Experiencia = años_Experiencia;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public Double getValoracion() {
        return Valoracion;
    }

    public void setValoracion(Double valoracion) {
        Valoracion = valoracion;
    }

    public List getComentarios() {
        return Comentarios;
    }

    public void setComentarios(List comentarios) {
        Comentarios = comentarios;
    }

    private Number Edad;
    private String Correo;
    private String Telefono;
    private String Años_Experiencia;
    private String Especialidad;
    private Double Valoracion;
    @Id
    private String _id;

    public Integer getNumeroVotaciones() {
        return numeroVotaciones;
    }

    public void setNumeroVotaciones(Integer numeroVotaciones) {
        this.numeroVotaciones = numeroVotaciones;
    }

    private Integer numeroVotaciones;
    private List<Comentarios> Comentarios;

}
