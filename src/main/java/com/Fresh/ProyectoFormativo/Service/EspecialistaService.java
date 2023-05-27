package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Especialista;

import java.util.List;

public interface EspecialistaService {
    public Especialista findEspecialistById(String id);
    public List<Especialista> findAllEspecialists();
    public Especialista insertOneEspecialista(Especialista especialista);
}
