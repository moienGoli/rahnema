package com.rahnema.db;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.inject.Singleton;

/**
 * Morphia object
 * Created by moien .
 */

@Singleton
public class MorphiaObj {

    private static String host = "localhost";
    private static int port = 27017;
    private static String db = "treasury";

    public static MongoClient mongoClient;
    public static Morphia morphia;
    public static Datastore ds;


    public static void initMorphia() {
        mongoClient = new MongoClient(new ServerAddress(host, port));
        morphia = new Morphia();
        ds = morphia.createDatastore(mongoClient, db);
    }


}