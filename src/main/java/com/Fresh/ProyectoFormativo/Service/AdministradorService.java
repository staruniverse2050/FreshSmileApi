package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Administrador;
import com.Fresh.ProyectoFormativo.Entity.Paciente;

import java.util.List;

public interface AdministradorService {

    public List<Administrador> ConsultarAdministrador();
    public Administrador CrearAdministrador(Administrador administrador);
    public Administrador ModificarAdministrador(Administrador administrador);
    public Administrador BuscarAdministrador(int id);
    public void EliminarAdministrador(int id);
    Administrador BuscarCredenciales(String correo, String contraseña);

}
