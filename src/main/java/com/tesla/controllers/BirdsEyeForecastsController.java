package com.tesla.controllers;

import com.tesla.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class BirdsEyeForecastsController {
    @FXML
    public void switchToPrimary() {
        try {
            App.setRoot("fxml/primary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
