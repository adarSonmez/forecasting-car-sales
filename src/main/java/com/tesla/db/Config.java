package com.tesla.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Config {
    private final static String username = "admin26";
    private final static String password = "k8LmIlY8VyiIRrLG";
    private final static String dbName = "forecast_app";
    private final static String url = MessageFormat.format("mongodb+srv://{0}:{1}@sandbox.3xclm.mongodb.net/{2}?retryWrites=true&w=majority", username, password, dbName);

    private static MongoCollection<Document> datasets;

    private Config() {
    }

    public static void connectDB() {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        MongoClient client = MongoClients.create(url);
        MongoDatabase database = client.getDatabase(dbName);
        datasets = database.getCollection("datasets");
        System.out.println("MongoDB connected");
    }

    public static MongoCollection<Document> getDatasetCollection() {
        return datasets;
    }
}