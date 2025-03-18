package edu.patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class PanelTemperatureIndicator implements Observer {

    private int currentTemperature = 0;

    @Override
    public void update(Observable o, Object arg) {
        currentTemperature = (Integer) arg;
    }

    @Override
    public String toString() {
        return "Your car temperature is: " + currentTemperature;
    }
}
