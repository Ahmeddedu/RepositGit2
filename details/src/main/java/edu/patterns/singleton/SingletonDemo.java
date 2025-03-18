package edu.patterns.singleton;

public class SingletonDemo {

    public static void main(String[] args) {
      //  Singleton c = new Singleton(); // will not compile beacause it's private.


        Singleton instance1 = Singleton.getInstance();
        instance1.increment();
        instance1.increment();
        System.out.println("Counter: " + instance1.getCounter()); // Output: Counter: 2

        Singleton instance2 = Singleton.getInstance();
        instance2.setCounter(10);
        System.out.println("Counter from instance1: " + instance1.getCounter()); // Output: 10

        System.out.println("m1 call");
        m1();
    }

    public static void m1 (){
        Singleton instance1 = Singleton.getInstance();
        instance1.increment();
        System.out.println("Counter: " + instance1.getCounter());
    }

}
