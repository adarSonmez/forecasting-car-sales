package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class DoubleExponentialSmoothing {
    private static double MSE;
    private static final double DE_ALPHA = 0.2;
    private static final double BETA = 0.2;
    private static final int INITIAL_S = 200;
    private static final int INITIAL_G = 50;

    public static MyArrayList<Integer> initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
        MyArrayList<Integer> arr = Dataset.getDataset(dataset);
        MyArrayList<Integer> frr = new MyArrayList<>();

        MyArrayList<Integer> arrS = new MyArrayList<>();
        arrS.add(INITIAL_S);
        MyArrayList<Integer> arrG = new MyArrayList<>();
        arrG.add(INITIAL_G);

        for (int i = 1; i < arr.size() + 1 ; i++){
            double result1 = (DE_ALPHA*arr.get(i-1) + (1-DE_ALPHA)*(arrS.get(i-1) + arrG.get(i-1)));
            arrS.add((int) result1);

            double result2 =(BETA*(arrS.get(i) - arrS.get(i-1)) + (1-BETA)*(arrG.get(i-1)));
            arrG.add((int) result2);
        }

        for (int i = 1; i < arr.size() + 1 ; i++){
            double forcast = arrS.get(i) + arrG.get(i);
            frr.add((int) forcast);
        }
        return frr;
    }

    public static double getMSE() {
        return MSE;
    }

    private static int calcMSE(Dataset dataset , MyArrayList<Integer> F) {
        int mse = 0;
        int add = 0;
        int sum = 0;
        MyArrayList<Integer> data = Dataset.getDataset(dataset);
        MyArrayList<Integer> arr = new MyArrayList<>();
        for (int i = 0 ; i < F.size() ; i++){
            add = (data.get(i) - F.get(i))*(data.get(i) - F.get(i));
            sum += mse;
        }
        mse = sum/F.size();
        System.out.println(mse);
        return mse;
    }
}
