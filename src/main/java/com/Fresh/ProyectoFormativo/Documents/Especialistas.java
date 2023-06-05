package com.Fresh.ProyectoFormativo.Documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Especialistas")
@AllArgsConstructor
@Data
public class Especialistas {

    @Id
    private String id;
    private String Nombre;
    private Number Edad;
    private String Correo;
    private String Telefono;
    private String Años_Experiencia;
    private String Especialidad;
    private String foto_perfil;
    private Double Valoracion;
    private List<Number> registroVotaciones;
    private List<Comentarios> Comentarios;


}
