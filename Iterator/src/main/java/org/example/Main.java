package org.example;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence fibSeq = new FibonacciSequence(10);
        Iterator<Integer> iterator = fibSeq.iterator();

        System.out.println("First 10 Fibonacci numbers:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
    // regarding the question where to store the state of the fibonacci sequence, in the iterator or in sequence,
    // the answer is in the iterator, the reason is that storing the state of the fibonacci sequence in the iterator
    // will create a stateful iterator, we can use multiple iterator interact with the sequence and it will not interfere
    // with how the sequence is gerated
    // if we save the state in the sequence, we share a same state to all the iterator, which defeat the purpose of using multiple iterator
}