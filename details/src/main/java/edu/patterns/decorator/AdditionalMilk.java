package edu.patterns.decorator;

import java.util.List;

public class AdditionalMilk extends Beverage {

    private Beverage base;

    public AdditionalMilk(Beverage base) {
        this.base = base;
    }

    @Override
    public int cost() {
        return base.cost() + 3;
    }

    @Override
    public List<String> ingridients() {
        List<String> ingr = base.ingridients();
        ingr.add("milk");
        return ingr;
    }

}
