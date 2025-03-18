package edu.patterns.templateMethod.bad;

public class DuplicatedTea {
    public void makeIt() {
        boilingWater();
        pourWater();
        addingTea();
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

    public void addingTea() {
        System.out.println("adding Tea 2 the cup");
    }


}
