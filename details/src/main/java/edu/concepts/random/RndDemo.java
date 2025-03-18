package edu.concepts.random;

import java.util.Random;

public class RndDemo {
    public static void main(String... args) {
        randomRandom();
    }

    private static void randomRandom() {
        Random r = new Random();

        System.out.println(r.nextBoolean());
        System.out.println(r.nextBoolean());
        System.out.println(r.nextBoolean());
        System.out.println(r.nextBoolean());
        System.out.println("LINE");
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(18));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
    }

    private static int randomRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    private static void mathRandom() {
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println(Math.random());


        System.out.println("start meaningful");

        double a = Math.random(); //  vid 0  do 1   dribne.
        System.out.println("random: "+ a);
        // task:    random number from 0 to 5 ;
        a = a * 5;
        System.out.println("bigger a : "+ a);

        long t = Math.round(a);
        System.out.println(" final number : "+ t);
        //10 -15
        System.out.println(" final number 10-15  : "+ (t +10));


        System.out.println(Math.round(Math.random() * 10));
        System.out.println(Math.round(Math.random() * 10));
        System.out.println(Math.round(Math.random() * 10));
        System.out.println(Math.round(Math.random() * 10));
        System.out.println(Math.round(Math.random() * 10));

    }
}
