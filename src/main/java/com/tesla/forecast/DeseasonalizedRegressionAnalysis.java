package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class DeseasonalizedRegressionAnalysis {
    private static double MSE;
    private static int maxForecastedSales;
    private static int minForecastedSales;
    private static Dataset forecastedDataset;

    public static MyArrayList<Integer> initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
        MyArrayList<Integer> arr = dataset.getListOfRecords();
        MyArrayList<Integer> newArr= new MyArrayList<>();
        MyArrayList<Integer> arr1 = new MyArrayList<>();
        MyArrayList<Integer> arr2 = new MyArrayList<>();
        MyArrayList<Integer> frr = new MyArrayList<>();
        MyArrayList<Double> expectedDemands = new MyArrayList<>();
        MyArrayList<Double> deseasonDemand = new MyArrayList<>();
        MyArrayList<Double> periodFactors = new MyArrayList<>();
        double period = 0;
        double expectedDemand;
        double month = arr.size();
        double overAllAverageSum = 0;
        double deseasonalDemand = 0;
        double regressionAnalysis = 0;
        double rega = 0;
        double regb = 0;
        //y
        double calcOfSales = 0;
        //x
        double calcOfTime = 0;
        //x^2
        double calcOfTimePower = 0;
        //x.y
        double calcofMxS = 0;
        double averageOfSales = 0;
        double averageOfTime = 0;


        // Split one array to two array
        for (int i = 0; i < month ; i++){
            if (i < 12){
                arr1.add(arr.get(i));
            }
            else {
                arr2.add(arr.get(i));
            }
        }
        // Find expected Demands.
        for (int i = 0; i < month/2 ; i++){
            overAllAverageSum += arr1.get(i) + arr2.get(i);
            expectedDemand = (arr1.get(i) + arr2.get(i))/2;
            expectedDemands.add(expectedDemand);
        }
        //Get overAll Average.
        double overAllAverage = overAllAverageSum / arr.size();

        //Get Every period for 12 month. I did it twice because I will use them correct position.
        for (int i = 0; i < expectedDemands.size() ; i++){
            period = expectedDemands.get(i)/overAllAverage;
            periodFactors.add(period);
        }
        for (int i = 0; i < expectedDemands.size() ; i++){
            period = expectedDemands.get(i)/overAllAverage;
            periodFactors.add(period);
        }

        //Get Deseason Demands.(y)
        for (int i = 0; i < month ; i++){
            deseasonalDemand = arr.get(i)/periodFactors.get(i);
            deseasonDemand.add(deseasonalDemand);
        }

        for (int i = 1; i < month + 1 ; i++){
            calcOfTime += i;
            calcOfTimePower += i*i;
            calcOfSales += deseasonDemand.get(i-1);
            calcofMxS += (i*(deseasonDemand.get(i-1)));
        }
        //~y
        averageOfSales = calcOfSales/month;
        //~x
        averageOfTime = calcOfTime/month;
        //regb
        regb = ((month * calcofMxS) - (calcOfTime * calcOfSales)) /
                ((month * calcOfTimePower) - (calcOfTime * calcOfTime));
        //rega
        rega = averageOfSales - regb * averageOfTime;
        //Find forecasts and add into an array.
        for (int i = 25; i < month + 25; i++) {
            regressionAnalysis = rega + (regb * (i));
            frr.add((int) regressionAnalysis);
        }
        System.out.println(frr);
        return frr;
    }

    public static double getMSE() {
        return MSE;
    }

    private static int calcMSE(Dataset dataset, MyArrayList<Integer> F) {
        int mse = 0;
        int add = 0;
        int sum = 0;
        MyArrayList<Integer> data = dataset.getListOfRecords();
        MyArrayList<Integer> arr = new MyArrayList<>();
        for (int i = 0; i < F.size(); i++) {
            add = (data.get(i) - F.get(i)) * (data.get(i) - F.get(i));
            sum += add;
        }
        mse = sum / F.size();
        System.out.println(mse);
        return mse;
    }

    public static int getMaxForecastedSales() {
        return maxForecastedSales;
    }

    public static void setMaxForecastedSales(int maxForecastedSales) {
        DeseasonalizedRegressionAnalysis.maxForecastedSales = maxForecastedSales;
    }

    public static int getMinForecastedSales() {
        return minForecastedSales;
    }

    public static void setMinForecastedSales(int minForecastedSales) {
        DeseasonalizedRegressionAnalysis.minForecastedSales = minForecastedSales;
    }

    public static Dataset getForecastedDataset() {
        return forecastedDataset;
    }
}
