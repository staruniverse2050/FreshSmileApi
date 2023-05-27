package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document("Especialistas")
public class Especialista {
    public Especialista(String id, String nombre, String edad, String correo, String telefono, Integer añosExperiencia, String especialidad, Double valoracion, List<Especialista.Comentarios> comentarios) {
        this.id = id;
        Nombre = nombre;
        Edad = edad;
        Correo = correo;
        Telefono = telefono;
        Años_Experiencia = añosExperiencia;
        Especialidad = especialidad;
        Valoracion = valoracion;
        Comentarios = comentarios;
    }

    @Id
    private String id;
    private String Nombre;
    private String Edad;
    private String Correo;
    private String Telefono;
    private Integer Años_Experiencia;
    private String Especialidad;
    private Double Valoracion;
    private List<Comentarios> Comentarios;


    public class Comentarios{
        @MongoId
        private String UserId;
        private String Contendio;
        public String getUserId() { return UserId; }

        public void setUserId(String userId) { UserId = userId; }

        public String getContendio() { return Contendio; }

        public void setContendio(String contendio) { Contendio = contendio; }
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
    public String getNombre() { return Nombre; }

    public void setNombre(String nombre) { Nombre = nombre; }

    public String getEdad() { return Edad; }

    public void setEdad(String edad) { Edad = edad; }

    public String getCorreo() { return Correo; }

    public void setCorreo(String correo) { Correo = correo; }

    public String getTelefono() { return Telefono; }

    public void setTelefono(String telefono) { Telefono = telefono; }

    public Integer getAños_Experiencia() { return Años_Experiencia; }

    public void setAños_Experiencia(Integer años_Experiencia) { Años_Experiencia = años_Experiencia; }

    public String getEspecialidad() { return Especialidad; }

    public void setEspecialidad(String especialidad) { Especialidad = especialidad; }

    public Double getValoracion() { return Valoracion; }

    public void setValoracion(Double valoracion) { Valoracion = valoracion; }

    public List<Especialista.Comentarios> getComentarios() { return Comentarios; }

    public void setComentarios(List<Especialista.Comentarios> comentarios) { Comentarios = comentarios; }


}
