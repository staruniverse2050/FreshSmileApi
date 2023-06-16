package com.Fresh.ProyectoFormativo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories("com.Fresh.ProyectoFormativo.Repository.EspecialistaVCRepo")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        // TODO Auto-generated method stub
        return "FreshSmile";
    }
    
    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
