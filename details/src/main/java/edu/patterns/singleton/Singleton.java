package edu.patterns.singleton;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private int counter; // Integer counter


    private Singleton() {
        this.counter = 0;
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increment() {
        this.counter++;
    }
}
