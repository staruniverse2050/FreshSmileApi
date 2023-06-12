package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Especialista;

public interface EspecialistaCustomRepository {
    Especialista getEspecialistaByCorreo(String id);
}
