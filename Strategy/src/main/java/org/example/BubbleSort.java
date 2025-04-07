package org.example;


//https://www.geeksforgeeks.org/bubble-sort-algorithm/
public class BubbleSort extends Sort {

//    public BubbleSort(int[] integerArray) {
//        super(integerArray);
//    }

    @Override
    public void sort() {
        super.setStartTime();
        int[] arr = super.getIntegerArray();
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
        super.setEndTime();
        displaySortingTime();
        System.out.println("Done");
    }
}