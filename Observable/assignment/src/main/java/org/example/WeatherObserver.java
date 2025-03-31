package org.example;

public class WeatherObserver implements Observer {
    private WeatherStation weatherStation;
    private String name;

    public WeatherObserver(String name, WeatherStation weatherStation) {
        this.name = name;
        this.weatherStation = weatherStation;
        weatherStation.addObserver(this);
    }
    @Override
    public void update() {
        System.out.println(this+ " receives new temperature from " + weatherStation +"which is "+weatherStation.getCurTemp());
    }

    @Override
    public String toString() {
        return name;
    }
}
