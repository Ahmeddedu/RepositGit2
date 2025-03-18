package edu.patterns.decorator;

import java.util.List;

public class AdditionalSugar extends Beverage{

    private Beverage base;

    public AdditionalSugar(Beverage base) {
        this.base = base;
    }

    @Override
    public int cost() {
        return base.cost() + 1;
    }

    @Override
    public List<String> ingridients() {
        List<String> ingr = base.ingridients();
        ingr.add("sugar");
        return ingr;
    }
}
