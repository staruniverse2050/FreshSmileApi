package com.Fresh.ProyectoFormativo.Service.ProcedimientoServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Procedimiento;
import com.Fresh.ProyectoFormativo.Repository.ProcedimientoRepo;
import com.Fresh.ProyectoFormativo.Service.ProcedimientoService;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimientoServiceIMPL implements ProcedimientoService {
    @Autowired
    private ProcedimientoRepo repo;

    @Override
    public List<Procedimiento>ConsultarProcedimientos() {
        return (List<Procedimiento>) this.repo.findAll();
    }

    @Override
    public Procedimiento CrearProcedimiento(Procedimiento procedimiento) {
        procedimiento.setNombre(procedimiento.getNombre());
        return this.repo.save(procedimiento);
    }

    @Override
    public Procedimiento ModificarProcedimiento(Procedimiento procedimiento) {
        return this.repo.save(procedimiento);
    }

    @Override
    public Procedimiento BuscarProcedimiento(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarProcedimiento(int id) {
        this.repo.deleteById(id);
    }

    @Override
    public Procedimiento BuscarProcedimientoPorNombre(String nombreProcedimiento) {
        String jpql = "SELECT p FROM Procedimiento p WHERE p.nombre = :nombre";
        Session entityManager = null;
        TypedQuery<Procedimiento> query = entityManager.createQuery(jpql, Procedimiento.class);
        query.setParameter("nombre", nombreProcedimiento);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Si no se encuentra el procedimiento con el nombre dado
        }
    }

}