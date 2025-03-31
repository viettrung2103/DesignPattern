package org.example;// WeatherStation.java
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class WeatherStation extends Thread implements Observable{
    private final List<Observer> observers ;
    private volatile int curTemp;
    private final int MIN_TEMP = -20;
    private final int MAX_TEMP = 30;
    private final Random random = new Random();
    private String name;

    public WeatherStation(String name) {
        this.curTemp = random.nextInt((MAX_TEMP - MIN_TEMP) + 1) + MIN_TEMP;
        observers = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void addObserver(Observer observer) {
        System.out.println("Add observer "+observer);
        observers.add(observer);
    }

    public String getStationName(){
        return this.name;
    }

    public void setStationName(String name){
        this.name = name;
    }

    public void removeObserver(Observer observer) {
        System.out.println("Remove observer "+observer);
        observers.remove(observer);
    }



    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    private synchronized void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        int newTemp = curTemp + change;
        if (newTemp >= MIN_TEMP && newTemp <= MAX_TEMP) {
            System.out.println("New temperature: " + newTemp);
            System.out.println("Letting my subscriber knows about my new temperature");
            curTemp = newTemp;
            notifyObservers();
        }
    }

    public synchronized int getCurTemp(){
        return curTemp;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (true) {
            updateTemperature();
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
