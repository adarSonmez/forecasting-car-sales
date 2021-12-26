package com.tesla.controllers;

import com.tesla.components.AlertBox;
import com.tesla.ds.MyArrayList;
import com.tesla.ds.MyMap;
import javafx.scene.control.TextField;

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

    public MyMap<String, String[]> getFirstYear() {
        return getStringMyMap(jan1, feb1, mar1, apr1, may1, jun1, jul1, aug1, sep1, oct1, nov1, dec1);
    }

    public MyMap<String, String[]> getSecondYear() {
        return getStringMyMap(jan2, feb2, mar2, apr2, may2, jun2, jul2, aug2, sep2, oct2, nov2, dec2);
    }

    // put every dataset record to "my map"
    private MyMap<String, String[]> getStringMyMap(TextField jan, TextField feb, TextField mar, TextField apr, TextField may, TextField jun, TextField jul, TextField aug, TextField sep, TextField oct, TextField nov, TextField dec) {
        MyMap<String, String[]> records = new MyMap<>();

        records.put("January", jan.getText().split("-"));
        records.put("February", feb.getText().split("-"));
        records.put("March", mar.getText().split("-"));
        records.put("April", apr.getText().split("-"));
        records.put("May", may.getText().split("-"));
        records.put("Jun", jun.getText().split("-"));
        records.put("July", jul.getText().split("-"));
        records.put("August", aug.getText().split("-"));
        records.put("September", sep.getText().split("-"));
        records.put("October", oct.getText().split("-"));
        records.put("November", nov.getText().split("-"));
        records.put("December", dec.getText().split("-"));

        return records;
    }

    // check if dataset the user wants to add database valid
    public boolean isDatasetValid(MyMap<String, String[]> records1, MyMap<String, String[]> records2, TextField size) {
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

    // extract records from forecasted list and group them according to numOfRecs
    public String eachMonth(int monthNum, int numOfRecords, MyArrayList<Integer> list) {
        int pointer = (monthNum - 1) * numOfRecords;
        StringBuilder text = new StringBuilder();
        for (int i = pointer; i < pointer + numOfRecords; i++) {
            if (i == pointer + numOfRecords - 1)
                text.append(list.get(i));
            else
                text.append(list.get(i)).append("-");
        }
        return text.toString();
    }
}
