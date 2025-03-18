package edu.concepts.threads.wait;

class BurgerShop {
    private boolean burgerReady = false; // No burger at the start

    public synchronized void makeBurger() {
        System.out.println("👨‍🍳 Chef: Starting to make a burger...");
        try {
            Thread.sleep(1000); // Simulate burger making time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        burgerReady = true;
        System.out.println("👨‍🍳 Chef: Burger is ready! 🍔");
        this.notify(); // Notify the waiting customer
    }

    public synchronized void eatBurger() {
        while (!burgerReady) { // If no burger, wait
            System.out.println("😋 Customer: No burger yet... I'll wait.");
            try {
                this.wait(); // Customer waits for the chef
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("😋 Customer: Yay! Eating the burger! 🍔😋");
    }
}
