package com.Fresh.ProyectoFormativo.Service.EspecialistaServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Repository.EspecialistaRepo;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EspecialistaServiceIMPL implements EspecialistaService {
    @Autowired
    private EspecialistaRepo repo;
    @Override
    public List<Especialista> ConsultarEspecialistas() {
        return (List<Especialista>)this.repo.findAll();
    }

    @Override
    public String CrearEspecialista(Especialista especialista) {
        return this.repo.newEspecialist(especialista);
    }

    @Override
    public String ModificarEspecialista(Especialista especialista) {
        return this.repo.modifyEspecialist(especialista);
    }

    @Override
    public Especialista BuscarEspecialista(int id) { return this.repo.findEspecialistById(id); }

    @Override
    public String EliminarEspecialista(int id) {
        return this.repo.deleteEspecialist(id);
    }


}
