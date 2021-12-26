package com.tesla.db;

import com.mongodb.client.MongoCollection;
import com.tesla.ds.MyArrayList;
import com.tesla.ds.MyMap;
import org.bson.Document;

import java.util.Arrays;
import java.util.Map;

public class Controller {
    private Controller() {
    }

    public static void addDataset(String name, int numOfRecordsForEachMonth, MyMap<String, String[]> records1, MyMap<String, String[]> records2) {
        Document document = createDocumentToInsert(name, numOfRecordsForEachMonth, records1, records2);

        MongoCollection<Document> datasetCollection = Config.getDatasetCollection();
        datasetCollection.insertOne(document);
        System.out.println(name + " added to the Database.");
    }

    public static void updateDataset(String name, int numOfRecordsForEachMonth, MyMap<String, String[]> records1, MyMap<String, String[]> records2) {
        Document update = new Document("Name", name);
        Document document = createDocumentToInsert(name, numOfRecordsForEachMonth, records1, records2);

        MongoCollection<Document> datasetCollection = Config.getDatasetCollection();
        datasetCollection.replaceOne(update, document);
        System.out.println(name + " updated.");
    }

    private static Document createDocumentToInsert(String name, int numOfRecordsForEachMonth, MyMap<String, String[]> records1, MyMap<String, String[]> records2) {
        Document document = new Document("Name", name);
        Document firstYear = new Document();
        Document secondYear = new Document();

        for (int i = 0; i < records1.getSize(); i++) {
            firstYear.append(records1.keys().get(i), Arrays.asList(records1.values().get(i)));
        }

        for (int i = 0; i < records2.getSize(); i++) {
            secondYear.append(records2.keys().get(i), Arrays.asList(records2.values().get(i)));
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
