package edu.concepts.threads.race;

public class  WIthdrawsRunnable implements Runnable{

    private BankAccount ba;

    public WIthdrawsRunnable(BankAccount ba) {
        this.ba = ba;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            ba.withdraw(30);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
