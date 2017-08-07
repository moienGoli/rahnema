package com.rahnema.db;


/**
 * An extension of {@link org.mongodb.morphia.dao.DAO} which has additional methods for our requirements.
 * All repository interfaces must extends this class instead of morphia DAO.
 * Created by moien.
 */
public interface DAO<T, K> extends org.mongodb.morphia.dao.DAO<T, K> {

}