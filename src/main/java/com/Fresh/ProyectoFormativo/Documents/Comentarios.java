package com.Fresh.ProyectoFormativo.Documents;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class Comentarios{
    @MongoId
    private String UserId;
    private String Contendio;
    public String getUserId() { return UserId; }

    public void setUserId(String userId) { UserId = userId; }

    public String getContendio() { return Contendio; }

    public void setContendio(String contendio) { Contendio = contendio; }
}