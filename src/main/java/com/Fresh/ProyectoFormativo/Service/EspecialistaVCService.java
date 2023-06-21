package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Documents.Comentarios;
import com.Fresh.ProyectoFormativo.Documents.EspecialistaVC;
import com.Fresh.ProyectoFormativo.Documents.Voto;

import java.util.List;

public interface EspecialistaVCService {
    List<EspecialistaVC>  getAllEspecialist();
    EspecialistaVC createEspecialst(EspecialistaVC newEspecialist);
    void deleteEspecialst(String id);
    EspecialistaVC comentEspecialist(Comentarios newComent, String id);
    EspecialistaVC voteEspecialist(Voto vote, String id);
}
