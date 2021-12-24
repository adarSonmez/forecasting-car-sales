package com.tesla.db;

import com.mongodb.client.MongoCollection;
import com.tesla.ds.MyArrayList;
import org.bson.Document;

import java.util.Arrays;
import java.util.Map;

public class Controller {
    private Controller() {
    }

    public static void addDataset(String name, int numOfRecordsForEachMonth, Map<String, String[]> records1, Map<String, String[]> records2) {
        Document document = createDocumentToInsert(name, numOfRecordsForEachMonth, records1, records2);

        MongoCollection<Document> datasetCollection = Config.getDatasetCollection();
        datasetCollection.insertOne(document);
        System.out.println(name + " added to the Database.");
    }

    public static void updateDataset(String name, int numOfRecordsForEachMonth, Map<String, String[]> records1, Map<String, String[]> records2) {
        Document update = new Document("Name", name);
        Document document = createDocumentToInsert(name, numOfRecordsForEachMonth, records1, records2);

        MongoCollection<Document> datasetCollection = Config.getDatasetCollection();
        datasetCollection.replaceOne(update, document);
        System.out.println(name + " updated.");
    }

    private static Document createDocumentToInsert(String name, int numOfRecordsForEachMonth, Map<String, String[]> records1, Map<String, String[]> records2) {
        Document document = new Document("Name", name);
        Document firstYear = new Document();
        Document secondYear = new Document();

        for (var entry : records1.entrySet()) {
            firstYear.append(entry.getKey(), Arrays.asList(entry.getValue()));
        }

        for (var entry : records2.entrySet()) {
            secondYear.append(entry.getKey(), Arrays.asList(entry.getValue()));
        }

        document.append("First Year", firstYear);
        document.append("Second Year", secondYear);
        document.append("Number Of Records For Each Month", numOfRecordsForEachMonth);

        return document;
    }

    public static void deleteDataset(Document document) {
        MongoCollection<Document> datasetCollection = Config.getDatasetCollection();
        datasetCollection.deleteOne(document);
    }

    public static MyArrayList<Document> getAllDatasets() {
        MongoCollection<Document> datasetCollection = Config.getDatasetCollection();
        MyArrayList<Document> list = new MyArrayList<>();
        datasetCollection.find().forEach(list::add);
        return list;
    }
}
