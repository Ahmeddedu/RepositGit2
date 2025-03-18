package edu.patterns.observer;

import java.util.Observable;

public class CarTemperature extends Observable {

    private int temperature = 0;

    public void increment() {
        temperature++;
        setChanged();
        this.notifyObservers(temperature);

    }

    public void decrement() {
        temperature--;
        setChanged();
        this.notifyObservers(temperature);

    }
}
