package edu.patterns.singleton.preface;

public class StaticDynamicDemo {

    public static void main(String... args) {

        System.out.println("Static part");
        System.out.println(StaticPropertiesAndMethods.staticProperty);
        StaticPropertiesAndMethods.staticProperty = 15;
        System.out.println(StaticPropertiesAndMethods.staticProperty);
        StaticPropertiesAndMethods.doSomething();

        System.out.println("Dynamic  part");
        //  DynamicObject.doSomething();   // will not compile
        //   DynamicObject.a = 11 ;        // will not compile

        DynamicObject dynO = new DynamicObject();
        dynO.doSomething();
        System.out.println(dynO.a);
    }
}
