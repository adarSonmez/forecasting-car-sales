package com.tesla.controllers;

import com.tesla.App;
import com.tesla.components.AlertBox;
import com.tesla.ds.MyArrayList;
import com.tesla.forecast.DeseasonalizedRegressionAnalysis;
import com.tesla.forecast.DoubleExponentialSmoothing;
import com.tesla.forecast.ExponentialSmoothing;
import com.tesla.forecast.RegressionAnalysis;
import com.tesla.models.Dataset;
import com.tesla.models.ForecastMethod;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BirdsEyeForecastsController implements Initializable {
    private static Dataset dataset;
    public Label datasetName;
    public Label mostAccurateMethodLabel;

    public TableView<ForecastMethod> MethodsTable;
    public TableColumn<ForecastMethod, String> methodName;
    public TableColumn<ForecastMethod, Integer> minSales;
    public TableColumn<ForecastMethod, Integer> maxSales;
    public TableColumn<ForecastMethod, Double> mse;

    ObservableList<ForecastMethod> observableList = FXCollections.observableArrayList();

    public static Dataset getDataset() {
        return dataset;
    }

    public static void setDataset(Dataset dataset) {
        BirdsEyeForecastsController.dataset = dataset;
    }

    @FXML
    public void switchToPrimary() {
        try {
            App.setRoot("fxml/primary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getForecastedDataset(ActionEvent actionEvent) {
        ObservableList<ForecastMethod> selected = MethodsTable.getSelectionModel().getSelectedItems();
        if (selected.size() == 0) {
            AlertBox.displayAlert("Invalid Choice", "Please select a method.");
        } else if (selected.size() > 1) {
            AlertBox.displayAlert("Invalid Choice", "Please select only one method.");
        } else {
            ViewForecastedDataset.forecastedList = selected.get(0).getForecastedList();

            try {
                App.setRoot("fxml/view-forecasted-dataset");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datasetName.setText("Forecast Methods for " + dataset.getName());

        ForecastMethod exponentialSmoothing = new ForecastMethod("Exponential Smoothing", ExponentialSmoothing.getMaxForecastedSales(), ExponentialSmoothing.getMinForecastedSales(), ExponentialSmoothing.getForecastedList(), ExponentialSmoothing.getMSE());
        ForecastMethod doubleExponentialSmoothing = new ForecastMethod("Double Exponential Smoothing", DoubleExponentialSmoothing.getMaxForecastedSales(), DoubleExponentialSmoothing.getMinForecastedSales(), DoubleExponentialSmoothing.getForecastedList(), DoubleExponentialSmoothing.getMSE());
        ForecastMethod regressionAnalysis = new ForecastMethod("Regression Analysis", RegressionAnalysis.getMaxForecastedSales(), RegressionAnalysis.getMinForecastedSales(), RegressionAnalysis.getForecastedList(), RegressionAnalysis.getMSE());
        ForecastMethod deseasonalizedRegressionAnalysis = new ForecastMethod("Deseasonalized Regression Analysis", DeseasonalizedRegressionAnalysis.getMaxForecastedSales(), DeseasonalizedRegressionAnalysis.getMinForecastedSales(), DeseasonalizedRegressionAnalysis.getForecastedList(), DeseasonalizedRegressionAnalysis.getMSE());

        mostAccurateMethod(ExponentialSmoothing.getMSE(), DoubleExponentialSmoothing.getMSE(), RegressionAnalysis.getMSE(), DeseasonalizedRegressionAnalysis.getMSE());

        observableList.add(exponentialSmoothing);
        observableList.add(doubleExponentialSmoothing);
        observableList.add(regressionAnalysis);
        observableList.add(deseasonalizedRegressionAnalysis);

        methodName.setCellValueFactory(new PropertyValueFactory<>("name"));
        minSales.setCellValueFactory(new PropertyValueFactory<>("minSales"));
        maxSales.setCellValueFactory(new PropertyValueFactory<>("maxSales"));
        mse.setCellValueFactory(new PropertyValueFactory<>("MSE"));
        MethodsTable.setItems(observableList);
    }

    private void mostAccurateMethod(double exp, double dexp, double reg, double dreg) {
        String efficientMethod = "";
        if (exp <= dexp && exp <= reg && exp <= dreg)
            efficientMethod = "Exponential Smoothing";
        else if (dexp <= exp && dexp <= reg && dexp <= dreg)
            efficientMethod = "Double Exponential Smoothing";
        else if (reg <= exp && reg <= dexp && reg <= dreg)
            efficientMethod = "Regression Analysis";
        else
            efficientMethod = "Deseasonalized Regression Analysis";

        mostAccurateMethodLabel.setText("The most accurate method for this dataset is " + efficientMethod + ". But you can also get forecasted datasets in any method.");
    }
}
