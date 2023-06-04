package com.Fresh.ProyectoFormativo.Service.Tipo_citaServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Agenda;
import com.Fresh.ProyectoFormativo.Entity.Tipo_cita;
import com.Fresh.ProyectoFormativo.Repository.AgendaRepo;
import com.Fresh.ProyectoFormativo.Repository.Tipo_citaRepo;
import com.Fresh.ProyectoFormativo.Service.AgendaService;
import com.Fresh.ProyectoFormativo.Service.Tipo_citaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_citaServiceIMPL implements Tipo_citaService {
    @Autowired
    private Tipo_citaRepo repo;

    @Override
    public List<Tipo_cita> ConsultarTipo_cita() {
        return (List<Tipo_cita>) this.repo.findAll();
    }

    @Override
    public Tipo_cita CrearTipo_cita(Tipo_cita tipoCita) {
        tipoCita.setNombre(tipoCita.getNombre());
        return this.repo.save(tipoCita);
    }

    @Override
    public Tipo_cita ModificarTipo_cita(Tipo_cita tipoCita) {
        return this.repo.save(tipoCita);
    }

    @Override
    public Tipo_cita BuscarTipo_cita(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarTipo_cita(int id) {
        this.repo.deleteById(id);
    }
}