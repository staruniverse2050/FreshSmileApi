package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Documents.Especialistas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EspecialistaVCRepo extends MongoRepository<Especialistas, String> {
}
