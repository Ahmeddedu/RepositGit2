package edu.concepts.threads;

public class ThreadsDemo {
    public static void main(String... args) {

        SampleRunnableImpl a = new SampleRunnableImpl(50);
        SampleRunnableImpl b = new SampleRunnableImpl(49);

        Thread at = new Thread(a);
        Thread bt = new Thread(b);

        at.start();
        bt.start();
    }

    public static void byThread() {
        Thread t1 = new SampleThreadImpl(30);
        Thread t2 = new SampleThreadImpl(40);
        Thread t3 = new SampleThreadImpl(50);

        t1.start();
        t2.start();
        t3.start();
    }
}
