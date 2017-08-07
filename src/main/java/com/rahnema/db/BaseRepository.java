package com.rahnema.db;

import org.mongodb.morphia.dao.BasicDAO;

/**
 * Base class for Repositories.
 * Created by moien .
 */
public abstract class BaseRepository<T extends BaseEntity, K> extends BasicDAO<T, K> implements DAO<T, K> {

    public BaseRepository(Class<T> entityClass) {
        super(entityClass, MorphiaObj.mongoClient, MorphiaObj.morphia, MorphiaObj.ds.getDB().getName());
    }

}