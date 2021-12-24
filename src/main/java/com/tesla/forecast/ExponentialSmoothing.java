package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class ExponentialSmoothing {
    private static final double E_ALPHA = 0.2;
    private static double MSE;

    public static MyArrayList<Integer> initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
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
        System.out.println("Original Dataset:      " + arr);
        System.out.println("Exponential Smoothing: " + frr);
        return frr;
    }

    public static double getMSE() {
        return MSE;
    }

    //Changed void to int.
    private static int calcMSE(Dataset dataset, MyArrayList<Integer> F) {
        int mse = 0;
        int add = 0;
        int sum = 0;
        MyArrayList<Integer> data = dataset.getListOfRecords();
        MyArrayList<Integer> arr = new MyArrayList<>();
        for (int i = 0; i < F.size(); i++) {
            add = (data.get(i) - F.get(i)) * (data.get(i) - F.get(i));
            sum += mse;
        }
        mse = sum / F.size();
        System.out.println(mse);
        return mse;
    }
}
