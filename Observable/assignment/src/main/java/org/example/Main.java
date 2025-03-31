package org.example;

public class Main {
    public static void main(String[] args) {

        WeatherStation station = new WeatherStation("Helsinki Weather Station");

        WeatherObserver obs1 = new WeatherObserver("Observer 1",station);
        WeatherObserver obs2 = new WeatherObserver("Observer 2",station);
        WeatherObserver obs3 = new WeatherObserver("Observer 3",station);

        try{
            station.start();
            Thread.sleep(15000); // Let it run for a bit

            System.out.println("Obser "+obs2+ " wants to remove from the weather station");
            station.removeObserver(obs2);

            Thread.sleep(15000); // Continue running
            System.out.println("Obser "+obs1+ " wants to remove from the weather station");
            station.removeObserver(obs1);

            Thread.sleep(15000);
            System.out.println("\nStopping simulation...\n");
            station.interrupt();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}