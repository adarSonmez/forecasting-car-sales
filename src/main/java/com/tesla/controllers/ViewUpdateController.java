package com.tesla.controllers;

import com.tesla.App;
import com.tesla.components.AlertBox;
import com.tesla.db.Controller;
import com.tesla.ds.MyMap;
import com.tesla.models.Dataset;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class ViewUpdateController extends HandleFields implements Initializable {
    public static Dataset dataset;
    public Label datasetName;
    public TextField valueToBeSearched;
    public Label television;

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
        String[] structure = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

        dataset.getJanuaryRecords1().forEach(r -> {
            if (Objects.equals(structure[0], ""))
                structure[0] += r;
            else
                structure[0] += "-" + r;
            jan1.setText(structure[0]);
        });

        dataset.getFebruaryRecords1().forEach(r -> {
            if (Objects.equals(structure[1], ""))
                structure[1] += r;
            else
                structure[1] += "-" + r;
            feb1.setText(structure[1]);
        });

        dataset.getMarchRecords1().forEach(r -> {
            if (Objects.equals(structure[2], ""))
                structure[2] += r;
            else
                structure[2] += "-" + r;
            mar1.setText(structure[2]);
        });

        dataset.getAprilRecords1().forEach(r -> {
            if (Objects.equals(structure[3], ""))
                structure[3] += r;
            else
                structure[3] += "-" + r;
            apr1.setText(structure[3]);
        });

        dataset.getMayRecords1().forEach(r -> {
            if (Objects.equals(structure[4], ""))
                structure[4] += r;
            else
                structure[4] += "-" + r;
            may1.setText(structure[4]);
        });

        dataset.getJunRecords1().forEach(r -> {
            if (Objects.equals(structure[5], ""))
                structure[5] += r;
            else
                structure[5] += "-" + r;
            jun1.setText(structure[5]);
        });

        dataset.getJulyRecords1().forEach(r -> {
            if (Objects.equals(structure[6], ""))
                structure[6] += r;
            else
                structure[6] += "-" + r;
            jul1.setText(structure[6]);
        });

        dataset.getAugustRecords1().forEach(r -> {
            if (Objects.equals(structure[7], ""))
                structure[7] += r;
            else
                structure[7] += "-" + r;
            aug1.setText(structure[7]);
        });

        dataset.getSeptemberRecords1().forEach(r -> {
            if (Objects.equals(structure[8], ""))
                structure[8] += r;
            else
                structure[8] += "-" + r;
            sep1.setText(structure[8]);
        });

        dataset.getOctoberRecords1().forEach(r -> {
            if (Objects.equals(structure[9], ""))
                structure[9] += r;
            else
                structure[9] += "-" + r;
            oct1.setText(structure[9]);
        });

        dataset.getNovemberRecords1().forEach(r -> {
            if (Objects.equals(structure[10], ""))
                structure[10] += r;
            else
                structure[10] += "-" + r;
            nov1.setText(structure[10]);
        });

        dataset.getDecemberRecords1().forEach(r -> {
            if (Objects.equals(structure[11], ""))
                structure[11] += r;
            else
                structure[11] += "-" + r;
            dec1.setText(structure[11]);
        });

        dataset.getJanuaryRecords2().forEach(r -> {
            if (Objects.equals(structure[12], ""))
                structure[12] += r;
            else
                structure[12] += "-" + r;
            jan2.setText(structure[12]);
        });

        dataset.getFebruaryRecords2().forEach(r -> {
            if (Objects.equals(structure[13], ""))
                structure[13] += r;
            else
                structure[13] += "-" + r;
            feb2.setText(structure[13]);
        });

        dataset.getMarchRecords2().forEach(r -> {
            if (Objects.equals(structure[14], ""))
                structure[14] += r;
            else
                structure[14] += "-" + r;
            mar2.setText(structure[14]);
        });

        dataset.getAprilRecords2().forEach(r -> {
            if (Objects.equals(structure[15], ""))
                structure[15] += r;
            else
                structure[15] += "-" + r;
            apr2.setText(structure[15]);
        });

        dataset.getMayRecords2().forEach(r -> {
            if (Objects.equals(structure[16], ""))
                structure[16] += r;
            else
                structure[16] += "-" + r;
            may2.setText(structure[16]);
        });

        dataset.getJunRecords2().forEach(r -> {
            if (Objects.equals(structure[17], ""))
                structure[17] += r;
            else
                structure[17] += "-" + r;
            jun2.setText(structure[17]);
        });

        dataset.getJulyRecords2().forEach(r -> {
            if (Objects.equals(structure[18], ""))
                structure[18] += r;
            else
                structure[18] += "-" + r;
            jul2.setText(structure[18]);
        });

        dataset.getAugustRecords2().forEach(r -> {
            if (Objects.equals(structure[19], ""))
                structure[19] += r;
            else
                structure[19] += "-" + r;
            aug2.setText(structure[19]);
        });

        dataset.getSeptemberRecords2().forEach(r -> {
            if (Objects.equals(structure[20], ""))
                structure[20] += r;
            else
                structure[20] += "-" + r;
            sep2.setText(structure[20]);
        });

        dataset.getOctoberRecords2().forEach(r -> {
            if (Objects.equals(structure[21], ""))
                structure[21] += r;
            else
                structure[21] += "-" + r;
            oct2.setText(structure[21]);
        });

        dataset.getNovemberRecords2().forEach(r -> {
            if (Objects.equals(structure[22], ""))
                structure[22] += r;
            else
                structure[22] += "-" + r;
            nov2.setText(structure[22]);
        });

        dataset.getDecemberRecords2().forEach(r -> {
            if (Objects.equals(structure[23], ""))
                structure[23] += r;
            else
                structure[23] += "-" + r;
            dec2.setText(structure[23]);
        });

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

    public void searchValue(ActionEvent actionEvent) {
        if (!containsOnlyNumbers(valueToBeSearched.getText())) {
            AlertBox.displayAlert("Invalid Input", "Your input must consist of numbers only");
            return;
        }

        if (dataset.getListOfRecords().contains(Integer.parseInt(valueToBeSearched.getText())))
            television.setText(valueToBeSearched.getText() + " is contained in the dataset.");
        else
            television.setText(valueToBeSearched.getText() + " is not found on in the dataset.");
    }

    public void printReversed(ActionEvent actionEvent) {
        television.setText("Reversed Dataset: " + dataset.getListOfRecords().getReverse().toString());
    }
}
