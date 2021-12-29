package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class DoubleExponentialSmoothing {
    private static final double ALPHA = 0.2;
    private static final double BETA = 0.2;
    private static final double INITIAL_S = 200;
    private static final double INITIAL_G = 50;
    private static double MSE;

    private static int maxForecastedSales;
    private static int minForecastedSales;
    private static MyArrayList<Integer> forecastedList;
    private static int numOfRecs;

    public static void initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
        numOfRecs = numOfRecordsForEachMonth;

        MyArrayList<Integer> arr = dataset.getListOfRecords();
        MyArrayList<Integer> frr = new MyArrayList<>();

        MyArrayList<Double> arrS = new MyArrayList<>();
        arrS.add(INITIAL_S);
        MyArrayList<Double> arrG = new MyArrayList<>();
        arrG.add(INITIAL_G);

        for (int i = 1; i < arr.size() + 1; i++) {
            double result1 = (ALPHA * arr.get(i - 1) + (1 - ALPHA) * (arrS.get(i - 1) + arrG.get(i - 1)));
            arrS.add(result1);

            double result2 = (BETA * (arrS.get(i) - arrS.get(i - 1)) + (1 - BETA) * (arrG.get(i - 1)));
            arrG.add(result2);
        }

        for (int i = 1; i < arr.size() + 1; i++) {
            double forecast = arrS.get(i) + arrG.get(i);
            frr.add((int) forecast);
        }

        MSE = ForecastUtil.calcMSE(dataset, frr);
        minForecastedSales = ForecastUtil.getMinForecastedSales(frr);
        maxForecastedSales = ForecastUtil.getMaxForecastedSales(frr);
        forecastedList = frr;
        System.out.println("Double Exponential Smoothing: " + frr);

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
