package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Administrador;
import com.Fresh.ProyectoFormativo.Entity.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface AdministradorRepo extends CrudRepository<Administrador,Integer> {
    Administrador findByCorreoAndContraseña(String correo, String contraseña);

}
