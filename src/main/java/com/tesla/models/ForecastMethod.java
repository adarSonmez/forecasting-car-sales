package com.tesla.models;

import com.tesla.ds.MyArrayList;

public class ForecastMethod {
    private String name;
    private int maxSales;
    private int minSales;
    private MyArrayList<Integer> forecastedList;
    private double MSE;

    public ForecastMethod(String name, int maxSales, int minSales, MyArrayList<Integer> forecastedList, double mse) {
        this.name = name;
        this.maxSales = maxSales;
        this.minSales = minSales;
        this.forecastedList = forecastedList;
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

    public MyArrayList<Integer> getForecastedList() {
        return forecastedList;
    }

    public void setForecastedList(MyArrayList<Integer> forecastedList) {
        this.forecastedList = forecastedList;
    }

    public double getMSE() {
        return MSE;
    }

    public void setMSE(double MSE) {
        this.MSE = MSE;
    }
}
