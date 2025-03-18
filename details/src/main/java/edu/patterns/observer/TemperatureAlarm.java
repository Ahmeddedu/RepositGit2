package edu.patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class TemperatureAlarm implements Observer {

    private int currentTemperature = 0;
    private static final int TEMPERATURE_LIMIT = 100;
    @Override
    public void update(Observable o, Object arg) {

        currentTemperature = (Integer) arg;
        if (currentTemperature > TEMPERATURE_LIMIT){
            System.out.println(" ALARM ALARM ALARM TO HOT HERE " + currentTemperature);
        }
    }

    @Override
    public String toString() {
        return "Your car temperature is: " + currentTemperature;
    }
}
