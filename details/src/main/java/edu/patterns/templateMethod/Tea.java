package edu.patterns.templateMethod;

public class Tea extends Beverage{
    @Override
    public void addingSomethingCustom() {
        System.out.println("adding Tea 2 the cup");
    }
}
