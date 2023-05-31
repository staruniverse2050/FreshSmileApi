package com.Fresh.ProyectoFormativo.Service.AdministradorServiceIMPL;


import com.Fresh.ProyectoFormativo.Entity.Administrador;
import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Repository.AdministradorRepo;
import com.Fresh.ProyectoFormativo.Service.AdministradorService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceIMPL implements AdministradorService {
@Autowired
private AdministradorRepo repo;

    @Override
    public List<Administrador> ConsultarAdministrador() {
        return (List<Administrador>) this.repo.findAll();
    }

    @Override
    public Administrador CrearAdministrador(Administrador administrador) {
        administrador.setNumero_documento_uadministrador(administrador.getNumero_documento_uadministrador());
        return this.repo.save(administrador);
    }

    @Override
    public Administrador ModificarAdministrador(Administrador administrador) {
        return this.repo.save(administrador);
    }

    @Override
    public Administrador BuscarAdministrador(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarAdministrador(int id) {
        this.repo.deleteById(id);
    }
    @Autowired
    private EntityManager entityManager;
    @Transactional
    public void actualizarEstadoAdministrador(Administrador administrador) {
        entityManager.merge(administrador);
    }

    @Override
    public Administrador BuscarCredenciales(String correo, String contraseña) {
        return repo.findByCorreoAndContraseña(correo, contraseña);
    }

}