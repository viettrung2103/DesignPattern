package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
    private int count = 0;
    private final int maxCount;
    private int prev = 0;
    private int curr = 1;

    public FibonacciIterator(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public boolean hasNext() {
        return count < maxCount;
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();

        int next = curr;
        curr += prev;
        prev = next;
        count++;
        return next;
    }
}