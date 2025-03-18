package edu.patterns.templateMethod.bad;

public class DuplicatedCoffee {
    public void makeIt() {
        boilingWater();
        pourWater();
        addingCoffee();
        ready();
    }

    public void boilingWater() {
        System.out.println("boiling water");
    }

    public void pourWater() {
        System.out.println("pouring water");
    }

    public void addingCoffee() {
        System.out.println("adding coffee 2 the cup");
    }

    public void ready() {
        System.out.println("beverage is ready! ");
    }
}
