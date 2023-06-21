package com.Fresh.ProyectoFormativo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClients;
import org.bson.Document;


@Configuration
@EnableMongoRepositories("com.Fresh.ProyectoFormativo.Repository.EspecialistaVCRepo")
public class MongoConfig extends AbstractMongoClientConfiguration {

    private String uri = "mongodb+srv://FreshSmile:Odontologia2023@freshsmile.zzw9762.mongodb.net/FreshSmile?retryWrites=true&w=majority";
    private String db = "FreshSmile";

    @Override
    protected String getDatabaseName() {
        // TODO Auto-generated method stub
        return this.db;
    }

    @Override
    public MongoClient mongoClient() {
        MongoClient client = MongoClients.create(uri);
        ListDatabasesIterable<Document> databases = client.listDatabases();
        databases.forEach(System.out::println);
        return client;
    }
    
    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
