package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class ExponentialSmoothing {
    private static final double E_ALPHA = 0.2;
    private static double MSE;
    private static int maxForecastedSales;
    private static int minForecastedSales;
    private static MyArrayList<Integer> forecastedList;
    private static int numOfRecs;

    public static MyArrayList<Integer> initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
        numOfRecs = numOfRecordsForEachMonth;

        MyArrayList<Integer> frr = new MyArrayList<>();
        MyArrayList<Integer> arr = dataset.getListOfRecords();

        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                frr.add(arr.get(0));
            } else {
                double forecast = ((arr.get(i) * E_ALPHA) + (frr.get(i - 1) * (1 - E_ALPHA)));
                frr.add((int) forecast);
            }
        }
        MSE = ForecastUtil.calcMSE(dataset, frr);
        minForecastedSales = ForecastUtil.getMinForecastedSales(frr);
        maxForecastedSales = ForecastUtil.getMaxForecastedSales(frr);
        forecastedList = frr;

        System.out.println("Exponential Smoothing:        " + frr);
        return frr;
    }

    public static double getMSE() {
        return MSE;
    }

    public static int getMaxForecastedSales() {
        return maxForecastedSales;
    }

    public static int getMinForecastedSales() {
        return minForecastedSales;
    }

    public static MyArrayList<Integer> getForecastedList() {
        return forecastedList;
    }

    public static int getNumOfRecs() {
        return numOfRecs;
    }
}
