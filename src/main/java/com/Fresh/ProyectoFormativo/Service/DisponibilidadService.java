package com.Fresh.ProyectoFormativo.Service;


import com.Fresh.ProyectoFormativo.Entity.Disponibilidad;

import java.util.List;

public interface DisponibilidadService {
    public List<Disponibilidad> ConsultarDisponibilidades();
    public Disponibilidad CrearDisponibilidad(Disponibilidad disponibilidad);
    public Disponibilidad ModificarDisponibilidad(Disponibilidad disponibilidad);
    public Disponibilidad BuscarDisponibilidad(int id);
    public void EliminarDisponibilidad(int id);
}