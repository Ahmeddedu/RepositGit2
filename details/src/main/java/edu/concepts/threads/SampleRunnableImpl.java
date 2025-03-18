package edu.concepts.threads;

import java.util.Random;

public class SampleRunnableImpl implements Runnable {
    int value;
    Random rnd = new Random();

    public SampleRunnableImpl(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < value; i++) {
            System.out.println(value + "    " + i);
            try {
                Thread.sleep(Math.abs(rnd.nextInt() % 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
