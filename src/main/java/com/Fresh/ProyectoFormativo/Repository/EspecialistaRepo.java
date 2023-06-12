package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface EspecialistaRepo extends CrudRepository<Especialista,Integer>, EspecialistaCustomRepository {
    @Procedure("ConsultarEspecialistaPorIdentificacion")
    Especialista findEspecialistById(int id);
    @Procedure("CrearEspecialista")
    String newEspecialist(Especialista newEspecialist);
    @Procedure("ModificarEspecialista")
    String modifyEspecialist(Especialista especialista);

    @Procedure("EliminarEspecialista")
    String deleteEspecialist(int id);


}
