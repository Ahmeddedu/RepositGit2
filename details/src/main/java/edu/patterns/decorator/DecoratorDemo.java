package edu.patterns.decorator;

public class DecoratorDemo {
    public static void main(String... args){
        WaterCup w = new WaterCup();

        Cappucino c = new Cappucino();

        System.out.println("water cost: " + w.cost() );
        System.out.println("water ingridients: " + w.ingridients() );
        System.out.println("capuccino cost : " + c.cost() );
        System.out.println("cappucino ingridients : " + c.ingridients() );

        System.out.println("OTHER APPROACH DEMO");
        Beverage custom = new AdditionalMilk(c);
        System.out.println("capuccino with additional milk cost : " + custom.cost() );
        System.out.println("cappucino with additional milk ingridients : " + custom.ingridients() );

        Beverage moreCustom = new AdditionalMilk(custom);
        System.out.println("capuccino with additional milk cost : " + moreCustom.cost() );
        System.out.println("cappucino with additional milk ingridients : " + moreCustom.ingridients() );


        Beverage moreCustomWithSugar = new AdditionalSugar(moreCustom);
        System.out.println("capuccino with additional milk cost : " + moreCustomWithSugar.cost() );
        System.out.println("cappucino with additional milk ingridients : " + moreCustomWithSugar.ingridients() );

    }
}
