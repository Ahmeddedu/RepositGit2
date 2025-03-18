package edu.concepts.threads.race;

public class BankAccount {

    private int balance = 100; // Initial balance

    public  void  withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " sees balance: " + balance);
            try {
                Thread.sleep(50); // Simulate thinking time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdraws " + amount + ", new balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw! Not enough money.");
        }
    }
}