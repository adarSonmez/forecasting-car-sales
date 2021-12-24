package com.tesla.models;

public class ForecastMethod {
    private String name;
    private int maxSales;
    private int minSales;
    private Dataset dataset;
    private double MSE;

    public ForecastMethod(String name, int maxSales, int minSales, Dataset dataset, double mse) {
        this.name = name;
        this.maxSales = maxSales;
        this.minSales = minSales;
        this.dataset = dataset;
        MSE = mse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSales() {
        return maxSales;
    }

    public void setMaxSales(int maxSales) {
        this.maxSales = maxSales;
    }

    public int getMinSales() {
        return minSales;
    }

    public void setMinSales(int minSales) {
        this.minSales = minSales;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public double getMSE() {
        return MSE;
    }

    public void setMSE(double MSE) {
        this.MSE = MSE;
    }
}
