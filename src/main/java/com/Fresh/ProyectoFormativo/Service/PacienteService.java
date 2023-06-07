package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> ConsultarPaciente();
    String CrearPaciente(Paciente paciente);
    String ModificarPaciente(Paciente paciente);
    Paciente BuscarPaciente(int id);
    String EliminarPaciente(int id);
}
