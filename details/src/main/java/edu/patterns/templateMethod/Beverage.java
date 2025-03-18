package edu.patterns.templateMethod;

public abstract class Beverage {

    public abstract void addingSomethingCustom();

    public void makeIt() {
        boilingWater();
        pourWater();
        addingSomethingCustom();
        ready();
    }

    public void boilingWater() {
        System.out.println("boiling water");
    }

    public void pourWater() {
        System.out.println("pouring water");
    }

    public void ready() {
        System.out.println("beverage is ready! ");
    }
}
