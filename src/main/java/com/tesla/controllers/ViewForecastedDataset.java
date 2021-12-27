package com.tesla.controllers;

import com.tesla.App;
import com.tesla.ds.MyArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ViewForecastedDataset extends HandleFields implements Initializable {
    public static int numOfRecs;
    public static String methodNameTxt;
    public static String datasetNameTxt;
    public static MyArrayList<Integer> forecastedList;
    public Label datasetName;
    public Label methodName;
    public Label television;

    public void sortDescending(ActionEvent actionEvent) {
        Integer[] arr = forecastedList.sortInDescendingOrder();
        television.setText(Arrays.toString(arr));
    }

    public void switchToBirdsEyeForecasts(ActionEvent actionEvent) {
        try {
            App.setRoot("fxml/birds-eye-forecast");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // first year
        jan1.setText(eachMonth(1,numOfRecs, forecastedList));
        feb1.setText(eachMonth(2,numOfRecs, forecastedList));
        mar1.setText(eachMonth(3,numOfRecs, forecastedList));
        apr1.setText(eachMonth(4,numOfRecs, forecastedList));
        may1.setText(eachMonth(5,numOfRecs, forecastedList));
        jun1.setText(eachMonth(6,numOfRecs, forecastedList));
        jul1.setText(eachMonth(7,numOfRecs, forecastedList));
        aug1.setText(eachMonth(8,numOfRecs, forecastedList));
        sep1.setText(eachMonth(9,numOfRecs, forecastedList));
        oct1.setText(eachMonth(10,numOfRecs, forecastedList));
        nov1.setText(eachMonth(11,numOfRecs, forecastedList));
        dec1.setText(eachMonth(12,numOfRecs, forecastedList));

        // second year
        jan2.setText(eachMonth(13, numOfRecs, forecastedList));
        feb2.setText(eachMonth(14, numOfRecs, forecastedList));
        mar2.setText(eachMonth(15, numOfRecs, forecastedList));
        apr2.setText(eachMonth(16, numOfRecs, forecastedList));
        may2.setText(eachMonth(17, numOfRecs, forecastedList));
        jun2.setText(eachMonth(18, numOfRecs, forecastedList));
        jul2.setText(eachMonth(19, numOfRecs, forecastedList));
        aug2.setText(eachMonth(20, numOfRecs, forecastedList));
        sep2.setText(eachMonth(21, numOfRecs, forecastedList));
        oct2.setText(eachMonth(22, numOfRecs, forecastedList));
        nov2.setText(eachMonth(23, numOfRecs, forecastedList));
        dec2.setText(eachMonth(24, numOfRecs, forecastedList));

        methodName.setText(methodNameTxt);
        datasetName.setText(datasetNameTxt);
    }
}
