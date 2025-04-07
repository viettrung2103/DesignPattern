package org.example;

public class SortContext{
    private Sort sort;
    private int[] array;

    public SortContext() {
//        this.sort = sort;
//        this.array = array;
//        this.setArray(array);
    }

    public void setStrategy(Sort sort) {
        this.sort = sort;
    }
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
//        this.array = array;
        this.sort.setIntegerArray(array);
    }

    public void sort() {
//        this.sort.setIntegerArray(ints);
        sort.sort();
    }
}
