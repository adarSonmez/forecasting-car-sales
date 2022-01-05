package com.tesla.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tesla.components.AlertBox;
import org.bson.Document;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Config {
    private final static String username = "mongo011322";
    private final static String password = "RrGLcL5jv4uiTcz6";
    private final static String dbName = "atlas_hackathon";
    private final static String url = MessageFormat.format("mongodb+srv://{0}:{1}@sandbox.3xclm.mongodb.net/{2}?retryWrites=true&w=majority", username, password, dbName);

    private static MongoCollection<Document> datasets;

    // connect to the mongoDB
    public static void connectDB() {
        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);

            MongoClient client = MongoClients.create(url);
            MongoDatabase database = client.getDatabase(dbName);
            datasets = database.getCollection("datasets");
            System.out.println("MongoDB connected");
        } catch (Exception e) {
            System.out.println("Please check your internet connection.");
            System.exit(0);
        }
    }

    public static MongoCollection<Document> getDatasetCollection() {
        return datasets;
    }
}
