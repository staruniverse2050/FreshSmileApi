package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Codigo_administrador;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface Codigo_administradorRepo extends CrudRepository<Codigo_administrador,Integer> {
    @Procedure("insertarCodigoAdministrador")
    void newCode(String code);

    @Procedure("consultarCodigoAdmin")
    String getCodigo_administrador();

    @Procedure("eliminarCodigoAdministrador")
    void deleteCodigo_administrador(String code);
}
