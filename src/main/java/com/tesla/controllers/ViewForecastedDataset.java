package com.tesla.controllers;

import com.tesla.App;
import com.tesla.ds.MyArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ViewForecastedDataset extends HandleFields implements Initializable {
    public static int numOfRecs;
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
        jan1.setText(eachMonth(1));
        feb1.setText(eachMonth(2));
        mar1.setText(eachMonth(3));
        apr1.setText(eachMonth(4));
        may1.setText(eachMonth(5));
        jun1.setText(eachMonth(6));
        jul1.setText(eachMonth(7));
        aug1.setText(eachMonth(8));
        sep1.setText(eachMonth(9));
        oct1.setText(eachMonth(10));
        nov1.setText(eachMonth(11));
        dec1.setText(eachMonth(12));

        jan2.setText(eachMonth(13));
        feb2.setText(eachMonth(14));
        mar2.setText(eachMonth(15));
        apr2.setText(eachMonth(16));
        may2.setText(eachMonth(17));
        jun2.setText(eachMonth(18));
        jul2.setText(eachMonth(19));
        aug2.setText(eachMonth(20));
        sep2.setText(eachMonth(21));
        oct2.setText(eachMonth(22));
        nov2.setText(eachMonth(23));
        dec2.setText(eachMonth(24));
    }

    private String eachMonth(int monthNum) {
        int pointer = (monthNum - 1) * numOfRecs;
        StringBuilder text = new StringBuilder();
        for (int i = pointer; i < pointer + numOfRecs; i++) {
            if (i == pointer + numOfRecs - 1)
                text.append(forecastedList.get(i));
            else
                text.append(forecastedList.get(i)).append("-");
        }
        return text.toString();
    }
}
