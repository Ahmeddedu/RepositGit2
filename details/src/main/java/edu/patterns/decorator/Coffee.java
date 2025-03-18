package edu.patterns.decorator;

import java.util.List;

public class Coffee extends WaterCup {

    @Override
    public int cost() {
        return super.cost() + 3;
    }

    @Override
    public List<String> ingridients() {
        List<String> ingr = super.ingridients();
        ingr.add("cofee");
        return ingr;
    }
}
