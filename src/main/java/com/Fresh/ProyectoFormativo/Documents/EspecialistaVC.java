package com.Fresh.ProyectoFormativo.Documents;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("EspecialistaValoracionComentarios")
@AllArgsConstructor
public class EspecialistaVC {
    @Id
    private String id;
    private int identificacion_especialista;
    private Double Valoracion;
    private List<Number> votos;
    private List Comentarios;

    public EspecialistaVC(int identificacion_especialista){
        this.identificacion_especialista = identificacion_especialista;
    }
}
