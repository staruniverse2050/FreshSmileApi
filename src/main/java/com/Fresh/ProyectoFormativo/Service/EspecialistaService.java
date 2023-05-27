package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Documents.Especialista;

import java.util.List;

public interface EspecialistaService {
    public Especialista findEspecialistById(String id);
    public List<Especialista> findAllEspecialists();
    public Especialista insertOneEspecialista(Especialista especialista);
    public void deleteOneEspecialista(String id);
    public Especialista updateOneEspecialista(Especialista newEspecialista, String id);
}
