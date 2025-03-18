package edu.patterns.templateMethod;

public class Coffee extends Beverage{

    @Override
    public void addingSomethingCustom() {
        System.out.println("adding coffee 2 the cup");
    }
}
