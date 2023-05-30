package com.Fresh.ProyectoFormativo.Service.DisponibilidadServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Disponibilidad;
import com.Fresh.ProyectoFormativo.Repository.DisponibilidadRepo;
import com.Fresh.ProyectoFormativo.Service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadServiceIMPL implements DisponibilidadService {
    @Autowired
    private DisponibilidadRepo repo;

    @Override
    public List<Disponibilidad> ConsultarDisponibilidades() {
        return (List<Disponibilidad>) this.repo.findAll();
    }

    @Override
    public Disponibilidad CrearDisponibilidad(Disponibilidad disponibilidad) {
        return this.repo.save(disponibilidad);
    }

    @Override
    public Disponibilidad ModificarDisponibilidad(Disponibilidad disponibilidad) {
        return this.repo.save(disponibilidad);
    }

    @Override
    public Disponibilidad BuscarDisponibilidad(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarDisponibilidad(int id) {
        this.repo.deleteById(id);
    }
}