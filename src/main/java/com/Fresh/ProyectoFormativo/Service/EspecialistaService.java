package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Entity.Paciente;

import java.util.List;

public interface EspecialistaService {
    public List<Especialista> ConsultarEspecialistas();
    public Especialista CrearEspecialista(Especialista especialista);
    public Especialista ModificarEspecialista(Especialista especialista);
    public Especialista BuscarEspecialista(int id);
    void EliminarEspecialista(int id);
    void actualizarEstadoEspecialista(Especialista especialista);

}
