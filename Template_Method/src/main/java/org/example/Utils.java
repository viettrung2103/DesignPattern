package org.example;

public class Utils {

    static int getRandomInt(int min, int max) {
        return (int)(Math.random()*(max-min+1)+min);
    }
}
