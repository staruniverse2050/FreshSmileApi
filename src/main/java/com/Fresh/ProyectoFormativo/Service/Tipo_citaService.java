package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Entity.Tipo_cita;

import java.util.List;

public interface Tipo_citaService {
    List<Tipo_cita> ConsultarTipo_cita();
    Tipo_cita CrearTipo_cita(Tipo_cita tipoCita);
    Tipo_cita ModificarTipo_cita(Tipo_cita tipoCita);
    Tipo_cita BuscarTipo_cita(int id);
    void EliminarTipo_cita(int id);
}
