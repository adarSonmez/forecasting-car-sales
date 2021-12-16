package com.tesla.models;

import com.tesla.ds.MyArrayList;

public class Dataset {
    private final MyArrayList<MyArrayList<String>> allRecords = new MyArrayList<>();
    private final int minSalesCount;
    private final int maxSalesCount;
    private final String name;
    private final int numOfRecordsForEachMonth;
    private final int totalRecord;
    private final MyArrayList<String> januaryRecords1;
    private final MyArrayList<String> februaryRecords1;
    private final MyArrayList<String> marchRecords1;
    private final MyArrayList<String> aprilRecords1;
    private final MyArrayList<String> mayRecords1;
    private final MyArrayList<String> junRecords1;
    private final MyArrayList<String> julyRecords1;
    private final MyArrayList<String> augustRecords1;
    private final MyArrayList<String> septemberRecords1;
    private final MyArrayList<String> octoberRecords1;
    private final MyArrayList<String> novemberRecords1;
    private final MyArrayList<String> decemberRecords1;

    private final MyArrayList<String> januaryRecords2;
    private final MyArrayList<String> februaryRecords2;
    private final MyArrayList<String> marchRecords2;
    private final MyArrayList<String> aprilRecords2;
    private final MyArrayList<String> mayRecords2;
    private final MyArrayList<String> junRecords2;
    private final MyArrayList<String> julyRecords2;
    private final MyArrayList<String> augustRecords2;
    private final MyArrayList<String> septemberRecords2;
    private final MyArrayList<String> octoberRecords2;
    private final MyArrayList<String> novemberRecords2;
    private final MyArrayList<String> decemberRecords2;

    public Dataset(String name, int numOfRecordsForEachMonth, MyArrayList<String> januaryRecords1, MyArrayList<String> februaryRecords1, MyArrayList<String> marchRecords1, MyArrayList<String> aprilRecords1, MyArrayList<String> mayRecords1, MyArrayList<String> junRecords1, MyArrayList<String> julyRecords1, MyArrayList<String> augustRecords1, MyArrayList<String> septemberRecords1, MyArrayList<String> octoberRecords1, MyArrayList<String> novemberRecords1, MyArrayList<String> decemberRecords1, MyArrayList<String> januaryRecords2, MyArrayList<String> februaryRecords2, MyArrayList<String> marchRecords2, MyArrayList<String> aprilRecords2, MyArrayList<String> mayRecords2, MyArrayList<String> junRecords2, MyArrayList<String> julyRecords2, MyArrayList<String> augustRecords2, MyArrayList<String> septemberRecords2, MyArrayList<String> octoberRecords2, MyArrayList<String> novemberRecords2, MyArrayList<String> decemberRecords2) {
        this.name = name;
        this.numOfRecordsForEachMonth = numOfRecordsForEachMonth;
        this.totalRecord = numOfRecordsForEachMonth * 24;
        allRecords.add(this.januaryRecords1 = januaryRecords1);
        allRecords.add(this.februaryRecords1 = februaryRecords1);
        allRecords.add(this.marchRecords1 = marchRecords1);
        allRecords.add(this.aprilRecords1 = aprilRecords1);
        allRecords.add(this.mayRecords1 = mayRecords1);
        allRecords.add(this.junRecords1 = junRecords1);
        allRecords.add(this.julyRecords1 = julyRecords1);
        allRecords.add(this.augustRecords1 = augustRecords1);
        allRecords.add(this.septemberRecords1 = septemberRecords1);
        allRecords.add(this.octoberRecords1 = octoberRecords1);
        allRecords.add(this.novemberRecords1 = novemberRecords1);
        allRecords.add(this.decemberRecords1 = decemberRecords1);
        allRecords.add(this.januaryRecords2 = januaryRecords2);
        allRecords.add(this.februaryRecords2 = februaryRecords2);
        allRecords.add(this.marchRecords2 = marchRecords2);
        allRecords.add(this.aprilRecords2 = aprilRecords2);
        allRecords.add(this.mayRecords2 = mayRecords2);
        allRecords.add(this.junRecords2 = junRecords2);
        allRecords.add(this.julyRecords2 = julyRecords2);
        allRecords.add(this.augustRecords2 = augustRecords2);
        allRecords.add(this.septemberRecords2 = septemberRecords2);
        allRecords.add(this.octoberRecords2 = octoberRecords2);
        allRecords.add(this.novemberRecords2 = novemberRecords2);
        allRecords.add(this.decemberRecords2 = decemberRecords2);

        minSalesCount = getMinSalesCount();
        maxSalesCount = getMaxSalesCount();
    }

    public String getName() {
        return name;
    }

    public MyArrayList<MyArrayList<String>> getAllRecords() {
        return allRecords;
    }

    public int getMinSalesCount() {
        final int[] min = {Integer.MAX_VALUE};
        getAllRecords().forEach(r -> r.forEach(i -> {
            if (Integer.parseInt(i) < min[0]) min[0] = Integer.parseInt(i);
        }));

        return min[0];
    }

    public int getMaxSalesCount() {
        final int[] max = {Integer.MIN_VALUE};
        getAllRecords().forEach(r -> {
            r.forEach(i -> {
                if (Integer.parseInt(i) > max[0]) max[0] = Integer.parseInt(i);
            });
        });
        return max[0];
    }

    public int getNumOfRecordsForEachMonth() {
        return numOfRecordsForEachMonth;
    }


    public int getTotalRecord() {
        return totalRecord;
    }

    public MyArrayList<String> getJanuaryRecords1() {
        return januaryRecords1;
    }

    public MyArrayList<String> getFebruaryRecords1() {
        return februaryRecords1;
    }

    public MyArrayList<String> getMarchRecords1() {
        return marchRecords1;
    }

    public MyArrayList<String> getAprilRecords1() {
        return aprilRecords1;
    }

    public MyArrayList<String> getMayRecords1() {
        return mayRecords1;
    }


    public MyArrayList<String> getJunRecords1() {
        return junRecords1;
    }

    public MyArrayList<String> getJulyRecords1() {
        return julyRecords1;
    }


    public MyArrayList<String> getAugustRecords1() {
        return augustRecords1;
    }


    public MyArrayList<String> getSeptemberRecords1() {
        return septemberRecords1;
    }


    public MyArrayList<String> getOctoberRecords1() {
        return octoberRecords1;
    }


    public MyArrayList<String> getNovemberRecords1() {
        return novemberRecords1;
    }


    public MyArrayList<String> getDecemberRecords1() {
        return decemberRecords1;
    }


    public MyArrayList<String> getJanuaryRecords2() {
        return januaryRecords2;
    }


    public MyArrayList<String> getFebruaryRecords2() {
        return februaryRecords2;
    }


    public MyArrayList<String> getMarchRecords2() {
        return marchRecords2;
    }


    public MyArrayList<String> getAprilRecords2() {
        return aprilRecords2;
    }


    public MyArrayList<String> getMayRecords2() {
        return mayRecords2;
    }


    public MyArrayList<String> getJunRecords2() {
        return junRecords2;
    }


    public MyArrayList<String> getJulyRecords2() {
        return julyRecords2;
    }


    public MyArrayList<String> getAugustRecords2() {
        return augustRecords2;
    }


    public MyArrayList<String> getSeptemberRecords2() {
        return septemberRecords2;
    }


    public MyArrayList<String> getOctoberRecords2() {
        return octoberRecords2;
    }


    public MyArrayList<String> getNovemberRecords2() {
        return novemberRecords2;
    }


    public MyArrayList<String> getDecemberRecords2() {
        return decemberRecords2;
    }

}
