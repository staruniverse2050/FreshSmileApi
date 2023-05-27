package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Documents.Especialista;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EspecialistaRepo extends MongoRepository<Especialista, String> {
}
