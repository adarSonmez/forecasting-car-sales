package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class DoubleExponentialSmoothing {
    private static final double DE_ALPHA = 0.2;
    private static final double BETA = 0.2;
    private static final int INITIAL_S = 200;
    private static final int INITIAL_G = 50;
    private static double MSE;

    private static int maxForecastedSales;
    private static int minForecastedSales;
    private static MyArrayList<Integer> forecastedList;
    private static int numOfRecs;

    public static MyArrayList<Integer> initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
        numOfRecs = numOfRecordsForEachMonth;

        MyArrayList<Integer> arr = dataset.getListOfRecords();
        MyArrayList<Integer> frr = new MyArrayList<>();

        MyArrayList<Integer> arrS = new MyArrayList<>();
        arrS.add(INITIAL_S);
        MyArrayList<Integer> arrG = new MyArrayList<>();
        arrG.add(INITIAL_G);

        for (int i = 1; i < arr.size() + 1; i++) {
            double result1 = (DE_ALPHA * arr.get(i - 1) + (1 - DE_ALPHA) * (arrS.get(i - 1) + arrG.get(i - 1)));
            arrS.add((int) result1);

            double result2 = (BETA * (arrS.get(i) - arrS.get(i - 1)) + (1 - BETA) * (arrG.get(i - 1)));
            arrG.add((int) result2);
        }

        for (int i = 1; i < arr.size() + 1; i++) {
            double forcast = arrS.get(i) + arrG.get(i);
            frr.add((int) forcast);
        }
        MSE = ForecastUtil.calcMSE(dataset, frr);
        minForecastedSales = ForecastUtil.getMinForecastedSales(frr);
        maxForecastedSales = ForecastUtil.getMaxForecastedSales(frr);
        forecastedList = frr;
        System.out.println("Double Exponential Smoothing: " + frr);

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
