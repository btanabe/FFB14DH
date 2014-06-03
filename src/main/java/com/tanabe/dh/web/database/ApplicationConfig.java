package com.tanabe.dh.web.database;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by BTanabe on 6/2/2014.
 */
@Configuration
public class ApplicationConfig {
    protected String databaseHostAddress;
    protected int databasePort;
    protected String databaseName;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(databaseHostAddress, databasePort), databaseName);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate((mongoDbFactory()));
        return mongoTemplate;
    }

    //region SETTERS:
    public void setDatabaseHostAddress(String databaseHostAddress){
        this.databaseHostAddress = databaseHostAddress;
    }

    public void setDatabasePort(int databasePort){
        this.databasePort = databasePort;
    }

    public void setDatabaseName(String databaseName){
        this.databaseName = databaseName;
    }
    //endregion
}
