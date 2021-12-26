package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class DeseasonalizedRegressionAnalysis {
    private static double MSE;
    private static int maxForecastedSales;
    private static int minForecastedSales;
    private static MyArrayList<Integer> forecastedList;
    private static int numOfRecs;

    public static void initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
        numOfRecs = numOfRecordsForEachMonth;

        MyArrayList<Integer> arr = dataset.getListOfRecords();
        MyArrayList<Integer> arr1 = new MyArrayList<>();
        MyArrayList<Integer> arr2 = new MyArrayList<>();
        MyArrayList<Integer> frr = new MyArrayList<>();
        MyArrayList<Double> expectedDemands = new MyArrayList<>();
        MyArrayList<Double> deseasonDemand = new MyArrayList<>();
        MyArrayList<Double> periodFactors = new MyArrayList<>();

        double period;
        double expectedDemand;
        double month = arr.size();
        double overAllAverageSum = 0;
        double deseasonalDemand;
        double regressionAnalysis;
        double rega;
        double regb;
        // y
        double calcOfSales = 0;
        // x
        double calcOfTime = 0;
        // x^2
        double calcOfTimePower = 0;
        // x.y
        double calcofMxS = 0;
        double averageOfSales;
        double averageOfTime;

        // split one array into two arrays
        for (int i = 0; i < month; i++) {
            if (i < 12 * numOfRecordsForEachMonth) {
                arr1.add(arr.get(i));
            } else {
                arr2.add(arr.get(i));
            }
        }

        // find expected demands
        for (int i = 0; i < month / 2; i++) {
            overAllAverageSum += arr1.get(i) + arr2.get(i);
            expectedDemand = (arr1.get(i) + arr2.get(i)) / 2.0;
            expectedDemands.add(expectedDemand);
        }

        double overAllAverage = overAllAverageSum / arr.size();

        // get every period for 12 month. I did it twice because I will use them correct position.
        for (int i = 0; i < expectedDemands.size(); i++) {
            period = expectedDemands.get(i) / overAllAverage;
            periodFactors.add(period);
        }
        for (int i = 0; i < expectedDemands.size(); i++) {
            period = expectedDemands.get(i) / overAllAverage;
            periodFactors.add(period);
        }

        // get deseasonalized demands. (y)
        for (int i = 0; i < month; i++) {
            deseasonalDemand = arr.get(i) / periodFactors.get(i);
            deseasonDemand.add(deseasonalDemand);
        }

        for (int i = 1; i < month + 1; i++) {
            calcOfTime += i;
            calcOfTimePower += i * i;
            calcOfSales += deseasonDemand.get(i - 1);
            calcofMxS += (i * (deseasonDemand.get(i - 1)));
        }

        averageOfSales = calcOfSales / month; //~y
        averageOfTime = calcOfTime / month; //~x
        regb = ((month * calcofMxS) - (calcOfTime * calcOfSales)) /
                ((month * calcOfTimePower) - (calcOfTime * calcOfTime));
        rega = averageOfSales - regb * averageOfTime;

        // find forecasts and add them into an array.
        for (int i = 25; i < month + 25; i++) {
            regressionAnalysis = rega + (regb * (i));
            frr.add((int) regressionAnalysis);
        }

        MSE = ForecastUtil.calcMSE(dataset, frr);
        minForecastedSales = ForecastUtil.getMinForecastedSales(frr);
        maxForecastedSales = ForecastUtil.getMaxForecastedSales(frr);
        forecastedList = frr;

        System.out.println("Deseasonalized Reg. Analysis: " + frr);
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
