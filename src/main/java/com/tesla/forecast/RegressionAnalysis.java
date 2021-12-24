package com.tesla.forecast;

import com.tesla.ds.MyArrayList;
import com.tesla.models.Dataset;

public class RegressionAnalysis {
    private static double MSE;

    public static MyArrayList<Integer> initializeForecast(int numOfRecordsForEachMonth, Dataset dataset) {
        MyArrayList<Integer> arr = dataset.getListOfRecords();
        MyArrayList<Integer> frr = new MyArrayList<>();
        double regressionAnalysis = 0;
        int month = arr.size();
        double rega = 0;
        double regb = 0;
        double sumOfAv1 = 0;
        //x
        int calcOfTime = 0;
        //y
        int calcOfSales = 0;
        //x^2
        int calcOfTimePower = 0;
        //x.y
        int calcOfMxS = 0;
        double averageOfSales = 0;
        double averageTime = 0;
        for (int i = 1; i < month + 1; i++) {
            calcOfTime += i;
            calcOfSales += arr.get(i - 1);
            calcOfTimePower = i * i;
            calcOfMxS = (i * (arr.get(i - 1)));
            sumOfAv1 += arr.get(i - 1);
        }
        //~y
        averageOfSales = sumOfAv1 / month;
        //~x
        averageTime = calcOfTime / month;
        //regb
        regb = ((month * calcOfMxS) - (calcOfTime * calcOfSales)) /
                ((month * calcOfTimePower) - (calcOfTime * calcOfTime));
        //rega
        rega = averageOfSales - regb * averageTime;
        //regressionAnalaysis
        for (int i = 0; i < month; i++) {
            regressionAnalysis = rega + (regb * i);
            frr.add((int) regressionAnalysis);
        }
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
