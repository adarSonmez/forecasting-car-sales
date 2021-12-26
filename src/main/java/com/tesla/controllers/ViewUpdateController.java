package com.tesla.controllers;

import com.tesla.App;
import com.tesla.components.AlertBox;
import com.tesla.db.Controller;
import com.tesla.ds.MyMap;
import com.tesla.models.Dataset;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewUpdateController extends HandleFields implements Initializable {
    public static Dataset dataset;
    public Label datasetName;
    public TextField valueToBeSearched;
    public Label television;

    // if user clicks update button, this method will run
    public void updateDataset() {
        MyMap<String, String[]> records1 = getFirstYear();
        MyMap<String, String[]> records2 = getSecondYear();

        boolean valid = isDatasetValid(records1, records2, numOfRecs);

        if (valid) {
            Controller.updateDataset(dataset.getName(), Integer.parseInt(numOfRecs.getText()), records1, records2);
            switchToPrimary();
        }
    }

    @FXML
    public void switchToPrimary() {
        try {
            App.setRoot("fxml/primary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // first year
        jan1.setText(eachMonth(1, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        feb1.setText(eachMonth(2, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        mar1.setText(eachMonth(3, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        apr1.setText(eachMonth(4, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        may1.setText(eachMonth(5, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        jun1.setText(eachMonth(6, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        jul1.setText(eachMonth(7, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        aug1.setText(eachMonth(8, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        sep1.setText(eachMonth(9, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        oct1.setText(eachMonth(10, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        nov1.setText(eachMonth(11, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        dec1.setText(eachMonth(12, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));

        // second year
        jan2.setText(eachMonth(13, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        feb2.setText(eachMonth(14, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        mar2.setText(eachMonth(15, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        apr2.setText(eachMonth(16, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        may2.setText(eachMonth(17, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        jun2.setText(eachMonth(18, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        jul2.setText(eachMonth(19, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        aug2.setText(eachMonth(20, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        sep2.setText(eachMonth(21, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        oct2.setText(eachMonth(22, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        nov2.setText(eachMonth(23, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));
        dec2.setText(eachMonth(24, dataset.getNumOfRecordsForEachMonth(), dataset.getListOfRecords()));

        numOfRecs.setText(String.valueOf(dataset.getNumOfRecordsForEachMonth()));
        datasetName.setText(dataset.getName());
    }

    private boolean containsOnlyNumbers(String str) {
        if (str == null || str.length() == 0)
            return false;
        for (int i = 0; i < str.length(); i++)
            if (!Character.isDigit(str.charAt(i)))
                return false;
        return true;
    }

    // determine if a records is in the dataset or not
    public void searchValue() {
        if (!containsOnlyNumbers(valueToBeSearched.getText())) {
            AlertBox.displayAlert("Invalid Input", "Your input must consist of numbers only");
            return;
        }

        if (dataset.getListOfRecords().contains(Integer.parseInt(valueToBeSearched.getText())))
            television.setText(valueToBeSearched.getText() + " is contained in the dataset.");
        else
            television.setText(valueToBeSearched.getText() + " is not found on in the dataset.");
    }

    public void printReversed() {
        television.setText("Reversed Dataset: " + dataset.getListOfRecords().getReverse().toString());
    }
}
