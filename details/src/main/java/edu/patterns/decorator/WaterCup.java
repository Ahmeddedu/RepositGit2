package edu.patterns.decorator;

import java.util.List;

public class WaterCup extends Beverage {

    @Override
    public int cost() {
        return super.cost() + 1;
    }

    @Override
    public List<String> ingridients() {
        List<String> ingr = super.ingridients();
        ingr.add("water");
        return ingr;
    }
}
