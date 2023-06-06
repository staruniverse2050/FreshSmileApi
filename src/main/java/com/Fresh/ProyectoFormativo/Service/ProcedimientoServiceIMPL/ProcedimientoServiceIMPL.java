package com.Fresh.ProyectoFormativo.Service.ProcedimientoServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Procedimiento;
import com.Fresh.ProyectoFormativo.Repository.ProcedimientoRepo;
import com.Fresh.ProyectoFormativo.Service.ProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimientoServiceIMPL implements ProcedimientoService {
    @Autowired
    private ProcedimientoRepo repo;

    @Override
    public List<Procedimiento> ConsultarTipo_cita() {
        return (List<Procedimiento>) this.repo.findAll();
    }

    @Override
    public Procedimiento CrearTipo_cita(Procedimiento tipoCita) {
        tipoCita.setNombre(tipoCita.getNombre());
        return this.repo.save(tipoCita);
    }

    @Override
    public Procedimiento ModificarTipo_cita(Procedimiento tipoCita) {
        return this.repo.save(tipoCita);
    }

    @Override
    public Procedimiento BuscarTipo_cita(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarTipo_cita(int id) {
        this.repo.deleteById(id);
    }
}