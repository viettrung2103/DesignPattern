package org.example;

public class InsertSort extends Sort {

//    public InsertSort(int[] integerArray) {
//        super(integerArray);
//    }

    @Override
    public void sort() {
        super.setStartTime();
        int[] arr = super.getIntegerArray();
        {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }
        super.setEndTime();
        displaySortingTime();
        System.out.println("Done");
    }
}
