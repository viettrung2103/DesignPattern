package org.example;

import java.util.ArrayList;
import java.util.List;
public class GenerateNumList {

    public GenerateNumList() {}

    public int[] generateNumArray(int maxNum) {
        int[] newArray = new int[maxNum];
        for (int i = 0; i < maxNum; i++) {
            newArray[i] = generateNum(maxNum);
        }
        return newArray;
    }

    public int generateNum(int maxNum) {
        return (int) (Math.random() * (maxNum + 1));
    }
}