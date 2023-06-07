package com.Fresh.ProyectoFormativo.Service.PacienteServiceIMPL;
import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Repository.PacienteRepo;
import com.Fresh.ProyectoFormativo.Service.PacienteService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceIMPL implements PacienteService {

    @Autowired
    private PacienteRepo repo;
    @Override
    public List<Paciente> ConsultarPaciente() {
        return (List<Paciente>)this.repo.findAll();
    }

    @Override
    public String CrearPaciente(Paciente paciente) {
        return this.repo.createPacient(paciente);
    }

    @Override
    public String ModificarPaciente(Paciente paciente) {
        return this.repo.modifyPacient(paciente);
    }

    @Override
    public Paciente BuscarPaciente(int id) { return this.repo.findByPacientId(id); }

    @Override
    public String EliminarPaciente(int id) {
        return this.repo.deletePacient(id);
    }

    @Override
    public String changePacientStatus(int Id, boolean estatus) {
        return this.repo.changePacientStatus(Id, estatus);
    }


}