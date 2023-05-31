package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface PacienteRepo extends CrudRepository<Paciente, Integer> {
        Paciente findByCorreoPacienteAndContraseñaPaciente(String correo, String contraseña);

}
