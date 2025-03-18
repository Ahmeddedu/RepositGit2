package edu.patterns.templateMethod;

public class TemplateMethodDemo {
    public static void main(String... args){
        Coffee c = new Coffee();
        c.makeIt();

        Tea t = new Tea();
        t.makeIt();
    }
}
