package com.tanabe.dh.web.database;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by BTanabe on 6/2/2014.
 */
public class ApplicationConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "ffb14db";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }
}
