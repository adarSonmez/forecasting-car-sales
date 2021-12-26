package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class RegressionAnalysis {
    private static double MSE;
    private static int maxForecastedSales;
    private static int minForecastedSales;
    private static MyArrayList<Integer> forecastedList;
    private static int numOfRecs;

    public static void initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
        numOfRecs = numOfRecordsForEachMonth;

        MyArrayList<Integer> arr = dataset.getListOfRecords();
        MyArrayList<Integer> frr = new MyArrayList<>();
        double regressionAnalysis;
        double month = arr.size();
        double rega;
        double regb;

        double calcOfTime = 0; // x
        double calcOfSales = 0; // y
        double calcOfTimePower = 0; // x^2
        double calcOfMxS = 0; // x.y

        double averageOfSales;
        double averageTime;

        for (int i = 1; i < month + 1; i++) {
            calcOfTime += i;
            calcOfSales += arr.get(i - 1);
            calcOfTimePower += i * i;
            calcOfMxS += (i * (arr.get(i - 1)));
        }


        averageOfSales = calcOfSales / month; // ~y
        averageTime = calcOfTime / month; // ~x
        regb = ((month * calcOfMxS) - (calcOfTime * calcOfSales)) /
                ((month * calcOfTimePower) - (calcOfTime * calcOfTime));
        rega = averageOfSales - regb * averageTime;

        // regression process
        for (int i = 25; i < month + 25; i++) {
            regressionAnalysis = rega + (regb * i);
            frr.add((int) regressionAnalysis);
        }

        MSE = ForecastUtil.calcMSE(dataset, frr);
        minForecastedSales = ForecastUtil.getMinForecastedSales(frr);
        maxForecastedSales = ForecastUtil.getMaxForecastedSales(frr);
        forecastedList = frr;

        System.out.println("Regression Analysis:          " + frr);
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
