package edu.concepts.threads.wait;


public class WaitNotifyExample {
    public static void main(String[] args) {
        BurgerShop shop = new BurgerShop();

        BurgerClient client = new BurgerClient(shop);
        BurgerChef chef = new BurgerChef(shop);

        Thread customerThread = new Thread(client);
        Thread chefThread = new Thread(chef);

        customerThread.start();
        chefThread.start();
    }
}

class BurgerClient implements Runnable {

    private BurgerShop shop;

    public BurgerClient(BurgerShop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        shop.eatBurger();
    }
}

class BurgerChef implements Runnable {

    private BurgerShop shop;

    public BurgerChef(BurgerShop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        shop.makeBurger();
    }
}