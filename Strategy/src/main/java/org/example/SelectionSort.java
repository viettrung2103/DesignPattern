package org.example;


import java.util.List;

// reference from here:
//https://www.geeksforgeeks.org/selection-sort-algorithm-2/

public class SelectionSort extends Sort {

    public SelectionSort() {
        super();
    }

    @Override
    public void sort() {
        super.setStartTime();
        int[] arr = super.getIntegerArray();
        if (arr == null) {
            throw new IllegalStateException("Array is not initialized");
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
        super.setEndTime();
        displaySortingTime();
        System.out.println("Done");
    }
}