package edu.concepts.threads.HomeWork33;

import java.util.Random;

public class Potokisi {
    public static void main(String[] args) {
        int chisl = 120;// выбираем скок потоков

        for (int i = 0; i < chisl; i++) {

            Runnable zadach = new Randik();

            Thread potok = new Thread(zadach, "Potok" + i);

           potok.start();
        }
    }
}

class Randik implements Runnable {
    @Override
    public void run() {
        int rand = new Random().nextInt(100);
        System.out.println(Thread.currentThread().getName() + " - " + rand);
    }
}