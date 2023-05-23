package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Administrador;

import java.util.List;

public interface AdministradorService {

    public List<Administrador> ConsultarAdministrador();
    public Administrador CrearAdministrador(Administrador administrador);
    public Administrador ModificarAdministrador(Administrador administrador);
    public Administrador BuscarAdministrador(int id);
    public void EliminarAdministrador(int id);
}
