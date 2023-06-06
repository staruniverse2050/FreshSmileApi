package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Procedimiento;

import java.util.List;

public interface ProcedimientoService {
    List<Procedimiento> ConsultarTipo_cita();
    Procedimiento CrearTipo_cita(Procedimiento tipoCita);
    Procedimiento ModificarTipo_cita(Procedimiento tipoCita);
    Procedimiento BuscarTipo_cita(int id);
    void EliminarTipo_cita(int id);
}
