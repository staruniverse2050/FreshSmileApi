package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Documents.Comentarios;
import com.Fresh.ProyectoFormativo.Documents.Especialistas;

import java.util.List;

public interface EspecialistaVCService {
    List<Especialistas>  getAllEspecialist();
    Especialistas createEspecialst(Especialistas newEspecialist);
    Especialistas updateEspecialist(Especialistas newEspecialist,String id);
    void deleteEspecialst(String id);
    Especialistas comentEspecialist(Comentarios newComent, String id);
    Especialistas voteEspecialist(Number vote, String id);
}
