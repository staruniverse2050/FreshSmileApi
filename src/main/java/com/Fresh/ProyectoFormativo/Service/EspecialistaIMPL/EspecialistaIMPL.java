package com.Fresh.ProyectoFormativo.Service.EspecialistaIMPL;

import com.Fresh.ProyectoFormativo.Documents.Especialista;
import com.Fresh.ProyectoFormativo.Repository.EspecialistaRepo;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EspecialistaIMPL implements EspecialistaService {
    @Autowired
    private EspecialistaRepo repo;

    @Override
    public Especialista findEspecialistById(String id) { return this.repo.findById(id).get(); }

    @Override
    public List<Especialista> findAllEspecialists() {
        return this.repo.findAll();
    }

    @Override
    public Especialista insertOneEspecialista(Especialista especialista) {
        return this.repo.save(especialista);
    }

    @Override
    public void deleteOneEspecialista(String id) {
        this.repo.deleteById(id);
    }

    @Override
    public Especialista updateOneEspecialista(Especialista newEspecialista, String id) {
        Especialista oldEspecialista = this.repo.findById(id).get();
        oldEspecialista.
        return null;
    }
}
