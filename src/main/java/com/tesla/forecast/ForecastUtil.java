package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class ForecastUtil {
    public static int getMinForecastedSales(MyArrayList<Integer> frr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < frr.size(); i++)
            if (min > frr.get(i))
                min = frr.get(i);
        return min;
    }

    public static int getMaxForecastedSales(MyArrayList<Integer> frr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < frr.size(); i++)
            if (max < frr.get(i))
                max = frr.get(i);
        return max;
    }

    public static double calcMSE(Dataset dataset, MyArrayList<Integer> F) {
        int mse;
        int add;
        int sum = 0;
        MyArrayList<Integer> data = dataset.getListOfRecords();
        for (int i = 0; i < F.size(); i++) {
            add = (data.get(i) - F.get(i)) * (data.get(i) - F.get(i));
            sum += add;
        }
        mse = sum / F.size();
        return mse;
    }
}
