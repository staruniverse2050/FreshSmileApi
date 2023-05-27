package com.Fresh.ProyectoFormativo.Service.EspecialistaIMPL;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Repository.EspecialistaRepo;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EspecialistaIMPL implements EspecialistaService {
    @Autowired
    private EspecialistaRepo repo;

    @Override
    public Especialista findEspecialistById(String id) {
        return this.repo.findEspecialistById(id);
    }

    @Override
    public List<Especialista> findAllEspecialists() {
        return this.repo.findAll();
    }

    @Override
    public Especialista insertOneEspecialista(Especialista especialista) {
        return this.repo.save(especialista);
    }
}
