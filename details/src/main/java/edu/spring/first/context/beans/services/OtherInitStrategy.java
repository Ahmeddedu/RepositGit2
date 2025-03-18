package edu.spring.first.context.beans.services;

public class OtherInitStrategy {
    private String strategyName;

    public OtherInitStrategy(String strategyName) {
        this.strategyName = strategyName;
    }

    public void init() {
        System.out.println("other init strategy init");
    }

    public void doSomethingToo() {
        System.out.println("ois:" + strategyName);
    }
}
