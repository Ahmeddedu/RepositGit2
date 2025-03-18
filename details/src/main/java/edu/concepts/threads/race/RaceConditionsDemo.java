package edu.concepts.threads.race;

public class RaceConditionsDemo {

    public static void main(String[] args) {

        BankAccount sharedBankAccount = new BankAccount();
        BankAccount sharedBankAccount1 = new BankAccount();

        Runnable alice = new WIthdrawsRunnable(sharedBankAccount);
        Runnable bob = new WIthdrawsRunnable(sharedBankAccount1);

        Thread user1 = new Thread(alice, "Alice");
        Thread user2 = new Thread(bob, "Bob");

        user1.start();
        user2.start();
    }

    public static void main1(String[] args) {

        BankAccount sharedBankAccount = new BankAccount();

        Runnable alice = new WIthdrawsRunnable(sharedBankAccount);
        Runnable bob = new WIthdrawsRunnable(sharedBankAccount);

        Thread user1 = new Thread(alice, "Alice");
        Thread user2 = new Thread(bob, "Bob");

        user1.start();
        user2.start();
    }


}
