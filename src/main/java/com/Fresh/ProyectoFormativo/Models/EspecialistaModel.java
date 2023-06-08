package com.Fresh.ProyectoFormativo.Models;

import com.Fresh.ProyectoFormativo.Documents.EspecialistaVC;
import com.Fresh.ProyectoFormativo.Entity.Especialista;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class EspecialistaModel {
    public EspecialistaModel(EspecialistaVC especialistaVC, Especialista especialista){
        this.rating = especialistaVC;
        this.especialistaData = especialista;
    }
    private EspecialistaVC rating;
    private Especialista especialistaData;
}
