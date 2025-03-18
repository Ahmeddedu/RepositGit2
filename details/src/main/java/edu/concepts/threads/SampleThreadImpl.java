package edu.concepts.threads;

public class SampleThreadImpl extends Thread {
    int value;

    public SampleThreadImpl(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < value; i++) {
            System.out.println(value + "    " + i);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
