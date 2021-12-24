package com.tesla.forecast;

import com.tesla.models.Dataset;

public class DeseasonalizedRegressionAnalysis {
    private static double MSE;
    private static int maxForecastedSales;
    private static int minForecastedSales;
    private static Dataset forecastedDataset;

    public static void initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {

    }

    public static double getMSE() {
        return MSE;
    }

    private static void calcMSE() {
        // to do
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
