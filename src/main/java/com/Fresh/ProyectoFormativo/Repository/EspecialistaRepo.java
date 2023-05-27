package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EspecialistaRepo extends MongoRepository<Especialista, String> {

    @Query("{id : '?0'}")
    Especialista findEspecialistById(String id);
}
