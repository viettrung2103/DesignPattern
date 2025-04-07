package org.example;

import java.util.List;


public abstract class Sort {

    int[] integerArray;
    private long startTime;
    private long endTime;

    public Sort() {
//        this.integerArray = integerArray;
        startTime = 0;
        endTime = 0;
    }

    public int[] getIntegerArray() {
        return integerArray;
    }

    public void setIntegerArray(int[] integerArray) {
        this.integerArray = integerArray;
    }

    public long getTime() {
        return System.currentTimeMillis();
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public void displaySortingTime() {
        System.out.println("Sorting time: " + (endTime - startTime));
    }

    void printArray() {
        for (int val : this.integerArray) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    abstract void sort();
}