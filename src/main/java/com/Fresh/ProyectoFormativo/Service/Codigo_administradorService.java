package com.Fresh.ProyectoFormativo.Service;


import com.Fresh.ProyectoFormativo.Entity.Codigo_administrador;
import com.Fresh.ProyectoFormativo.Entity.Paciente;

import java.util.List;

public interface Codigo_administradorService {
    public List<Codigo_administrador> ConsultarCodigo();

    public void EliminarCodigo(String codigoAdministrador);
    public void CrearCodigo(Codigo_administrador codigoAdministrador);
}
