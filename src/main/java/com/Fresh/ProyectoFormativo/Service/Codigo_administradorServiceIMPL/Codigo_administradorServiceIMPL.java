package com.Fresh.ProyectoFormativo.Service.Codigo_administradorServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Citas;
import com.Fresh.ProyectoFormativo.Entity.Codigo_administrador;
import com.Fresh.ProyectoFormativo.Repository.Codigo_administradorRepo;
import com.Fresh.ProyectoFormativo.Service.Codigo_administradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Codigo_administradorServiceIMPL implements Codigo_administradorService {
    @Autowired
    private Codigo_administradorRepo repo;

    @Override
    public List<Codigo_administrador> ConsultarCodigo() {
        return (List<Codigo_administrador>) this.repo.findAll();
    }

    @Override
    public void EliminarCodigo(String code) {
        this.repo.deleteCodigo_administrador(code);
    }

    @Override
    public void CrearCodigo(Codigo_administrador code) {
        this.repo.newCode(code);
    }

}