package edu.concepts.threads.HomeWork34;

public class Main {
    private static final int max = 100000000; //  тут до какого числа считаем
    private static final int potok = 3; // сдеся количество потоков

    public static void main(String[] args) throws Exception {
        int[] chisla = new int[max];

        for (int i = 0; i < max; i++) {
            chisla[i] = (int) (Math.random() * 100);
        }

        long start = System.currentTimeMillis();
        long summa = sumParallel(chisla);
        long end = System.currentTimeMillis();

        System.out.println("Сумма: " + summa);
        System.out.println("Время (параллельное): " + (end - start) + " миллисекунд");

    }

    private static long sumParallel(int[] chisla) throws InterruptedException {
        int sizeChasti = max / potok;
        SumThread[] potoki = new SumThread[potok];
        int[] chastSum = new int[potok];

        // Запускаем потоки
        for (int i = 0; i < potok; i++) {
            final int index = i;
            potoki[i] = new SumThread(chisla, i * sizeChasti, (i + 1) * sizeChasti, chastSum, index);// говорб по чеснаку тут мне помог иишка
            potoki[i].start();
        }

        for (Thread potok : potoki) {
            potok.join();
        }

        long obshSum = 0;

        for (int sum : chastSum) {
            obshSum += sum;
        }

        return obshSum;
    }

    private static long sumSequential(int[] chisla) {
        long sum = 0;
        for (int chislo : chisla) {
            sum += chislo;
        }
        return sum;
    }
}
