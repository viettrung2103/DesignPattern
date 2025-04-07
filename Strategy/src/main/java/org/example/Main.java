package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenerateNumList generator = new GenerateNumList();
        int[] integerArray1 = generator.generateNumArray(1000);
        int[] integerArray2 = generator.generateNumArray(1000);
        int[] integerArray3 = generator.generateNumArray(1000);
        int[] integerArray4 = generator.generateNumArray(100000);
        int[] integerArray5 = generator.generateNumArray(100000);
        int[] integerArray6 = generator.generateNumArray(100000);

        Sort selectionSort = new SelectionSort();
        Sort bubbleSort = new BubbleSort();
        Sort insertSort = new InsertSort();

        SortContext sortContext = new SortContext();
        sortContext.setStrategy(selectionSort);
        sortContext.setArray(integerArray1);

        System.out.println("Sorting integerArray1 (1000), selection Sort");
        sortContext.sort();

        System.out.println("Sorting integerArray4 (100000), selection Sort");
        sortContext.setArray(integerArray4);
        sortContext.sort();

        System.out.println();
        System.out.println("Sorting integerArray2 (1000), bubble Sort");
        sortContext.setStrategy(bubbleSort);
        sortContext.setArray(integerArray2);
        sortContext.sort();

        System.out.println();
        System.out.println("Sorting integerArray5 (100000), bubble Sort");
        sortContext.setArray(integerArray5);
        sortContext.sort();

        System.out.println();
        System.out.println("Sorting integerArray3 (1000), insert Sort");
        sortContext.setStrategy(insertSort);
        sortContext.setArray(integerArray3);
        sortContext.sort();

        System.out.println();
        System.out.println("Sorting integerArray6 (100000), insert Sort");
        sortContext.setArray(integerArray6);
        sortContext.sort();
    }
}