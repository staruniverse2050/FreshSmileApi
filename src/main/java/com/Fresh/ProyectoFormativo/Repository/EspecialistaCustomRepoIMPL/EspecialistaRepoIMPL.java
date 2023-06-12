package com.Fresh.ProyectoFormativo.Repository.EspecialistaCustomRepoIMPL;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Repository.EspecialistaCustomRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

public class EspecialistaRepoIMPL implements EspecialistaCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Especialista getEspecialistaByCorreo(String id) {
        StoredProcedureQuery findByEmail = em.createNamedStoredProcedureQuery("ConsultarEspecialistaPorEmail").setParameter("p_correo", id);
        return (Especialista) findByEmail.getResultList().get(0);
    }

    
}
