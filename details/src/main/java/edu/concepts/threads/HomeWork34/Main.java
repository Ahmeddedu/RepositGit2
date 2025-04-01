package edu.concepts.threads.HomeWork34;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int max = 100000000; //тут до какого числа считаем
    private static final int potok = 3; // сдеся количество потоков

    public static void main(String[] args) throws Exception {
        int[] chisla = new int[max];

        for (int i = 0; i < max; i++) {
            chisla[i] = (int) (Math.random() * 100);
        }

        long start = System.currentTimeMillis();
        long summa = sumParallel(chisla);
        long end = System.currentTimeMillis();

        System.out.println("Сумма " + summa);
        System.out.println("Время " + (end - start) + " милисек");
    }

    private static long sumParallel(int[] chisla) throws InterruptedException {
        int rozmerChasti = max / potok;
        ExecutorService executor = Executors.newFixedThreadPool(potok);// через ExecutorService уже тут то я сделал просто как у вас
        int[] chastSum = new int[potok];


        for (int i = 0; i < potok; i++) {
            final int index = i;
            final int start = i * rozmerChasti;
            final int end = (i + 1) * rozmerChasti;

            executor.submit(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += chisla[j];
                }
                chastSum[index] = (int) sum;
            });
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

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