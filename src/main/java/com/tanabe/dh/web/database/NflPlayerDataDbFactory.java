package com.tanabe.dh.web.database;

import com.mongodb.DB;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;

/**
 * Created by BTanabe on 6/3/2014.
 */
public class NflPlayerDataDbFactory implements MongoDbFactory {


    @Override
    public DB getDb() throws DataAccessException {
        return null;
    }

    @Override
    public DB getDb(String dbName) throws DataAccessException {
        return null;
    }

    @Override
    public PersistenceExceptionTranslator getExceptionTranslator() {
        return null;
    }
}
