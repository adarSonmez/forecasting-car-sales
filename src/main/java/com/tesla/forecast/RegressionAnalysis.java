package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class RegressionAnalysis {
    private static double MSE;
    private static int maxForecastedSales;
    private static int minForecastedSales;
    private static MyArrayList<Integer> forecastedList;
    private static int numOfRecs;

    public static MyArrayList<Integer> initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
        numOfRecs = numOfRecordsForEachMonth;

        MyArrayList<Integer> arr = dataset.getListOfRecords();
        MyArrayList<Integer> frr = new MyArrayList<>();
        double regressionAnalysis = 0;
        double month = arr.size();
        double rega = 0;
        double regb = 0;
        //x
        double calcOfTime = 0;
        //y
        double calcOfSales = 0;
        //x^2
        double calcOfTimePower = 0;
        //x.y
        double calcOfMxS = 0;
        double averageOfSales = 0;
        double averageTime = 0;
        for (int i = 1; i < month + 1; i++) {
            calcOfTime += i;
            calcOfSales += arr.get(i - 1);
            calcOfTimePower += i * i;
            calcOfMxS += (i * (arr.get(i - 1)));
        }
        //~y
        averageOfSales = calcOfSales / month;
        //~x
        averageTime = calcOfTime / month;
        //regb
        regb = ((month * calcOfMxS) - (calcOfTime * calcOfSales)) /
                ((month * calcOfTimePower) - (calcOfTime * calcOfTime));
        //rega
        rega = averageOfSales - regb * averageTime;
        //regressionAnalaysis
        for (int i = 25; i < month + 25; i++) {
            regressionAnalysis = rega + (regb * i);
            frr.add((int) regressionAnalysis);
        }
        MSE = ForecastUtil.calcMSE(dataset, frr);
        minForecastedSales = ForecastUtil.getMinForecastedSales(frr);
        maxForecastedSales = ForecastUtil.getMaxForecastedSales(frr);
        forecastedList = frr;

        System.out.println("Regression Analysis:          " + frr);
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
