package com.tesla.controllers;

import com.tesla.components.AlertBox;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class HandleFields {
    public TextField numOfRecs;

    // first year
    public TextField jan1;
    public TextField feb1;
    public TextField mar1;
    public TextField apr1;
    public TextField may1;
    public TextField jun1;
    public TextField jul1;
    public TextField aug1;
    public TextField sep1;
    public TextField oct1;
    public TextField nov1;
    public TextField dec1;

    // second year
    public TextField jan2;
    public TextField feb2;
    public TextField mar2;
    public TextField apr2;
    public TextField may2;
    public TextField jun2;
    public TextField jul2;
    public TextField aug2;
    public TextField sep2;
    public TextField oct2;
    public TextField nov2;
    public TextField dec2;

    public Map<String, String[]> getFirstYear() {
        return getStringMap(jan1, feb1, mar1, apr1, may1, jun1, jul1, aug1, sep1, oct1, nov1, dec1);
    }

    public Map<String, String[]> getSecondYear() {
        return getStringMap(jan2, feb2, mar2, apr2, may2, jun2, jul2, aug2, sep2, oct2, nov2, dec2);
    }

    private Map<String, String[]> getStringMap(TextField jan, TextField feb, TextField mar, TextField apr, TextField may, TextField jun, TextField jul, TextField aug, TextField sep, TextField oct, TextField nov, TextField dec) {
        Map<String, String[]> records1 = new HashMap<>();

        records1.put("January", jan.getText().split("-"));
        records1.put("February", feb.getText().split("-"));
        records1.put("March", mar.getText().split("-"));
        records1.put("April", apr.getText().split("-"));
        records1.put("May", may.getText().split("-"));
        records1.put("Jun", jun.getText().split("-"));
        records1.put("July", jul.getText().split("-"));
        records1.put("August", aug.getText().split("-"));
        records1.put("September", sep.getText().split("-"));
        records1.put("October", oct.getText().split("-"));
        records1.put("November", nov.getText().split("-"));
        records1.put("December", dec.getText().split("-"));

        return records1;
    }

    public boolean isDatasetValid(Map<String, String[]> records1, Map<String, String[]> records2, TextField size) {
        if (size == null) {
            AlertBox.displayAlert("Fill in the blanks", "Please enter number of records for each month!");
            return false;
        } else if (Objects.equals(size.getText(), "")) {
            AlertBox.displayAlert("Fill in the blanks", "Please fill 'Number of records for each month' input");
            return false;
        }


        for (String[] record : records1.values()) {
            if (record.length != Integer.parseInt(size.getText())) {
                AlertBox.displayAlert("Invalid Input", "Please enter " + Integer.parseInt(size.getText()) + " records for each month.");
                return false;
            } else if (Objects.equals(record[0], "")) {
                AlertBox.displayAlert("Invalid Input", "Please enter " + Integer.parseInt(size.getText()) + " records for each month.");
                return false;
            }
        }
        for (String[] record : records2.values()) {
            if (record.length != Integer.parseInt(size.getText())) {
                AlertBox.displayAlert("Invalid Input", "Please enter " + size.getText() + " records for each month.");
                return false;
            } else if (Objects.equals(record[0], "")) {
                AlertBox.displayAlert("Invalid Input", "Please enter " + Integer.parseInt(size.getText()) + " records for each month.");
                return false;
            }
        }
        return true;
    }
}