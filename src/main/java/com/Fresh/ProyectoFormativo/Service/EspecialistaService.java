package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Especialista;

import java.util.List;

public interface EspecialistaService {
    List<Especialista> ConsultarEspecialistas();
    String CrearEspecialista(Especialista especialista);
    String ModificarEspecialista(Especialista especialista);
    Especialista BuscarEspecialista(int id);
    String EliminarEspecialista(int id);
}
