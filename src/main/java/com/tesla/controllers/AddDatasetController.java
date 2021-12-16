package com.tesla.controllers;

import com.tesla.App;
import com.tesla.db.Controller;
import javafx.fxml.FXML;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class AddDatasetController extends HandleFields {

    @FXML
    private void switchToPrimary() {
        try {
            App.setRoot("fxml/primary");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void submitDataset() {
        Map<String, String[]> records1 = getFirstYear();
        Map<String, String[]> records2 = getSecondYear();

        String name = nameDataset();

        boolean valid = isDatasetValid(records1, records2, numOfRecs);

        if (valid) {
            Controller.addDataset(name, Integer.parseInt(numOfRecs.getText()), records1, records2);
            switchToPrimary();
        }
    }

    private String nameDataset() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return "Dataset " + dtf.format(now);
    }
}