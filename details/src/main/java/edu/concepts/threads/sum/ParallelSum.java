package edu.concepts.threads.sum;

import java.util.Random;

public class ParallelSum {
    private static final int SIZE = 100_000_000; //
    private static final int THREADS = 10; // Number of threads

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[SIZE];
        Random random = new Random();

        // Fill the array with random numbers
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = random.nextInt(100);
        }

        // Parallel sum calculation
        long startTime = System.currentTimeMillis();
        int parallelSum = parallelSum(numbers);
        long endTime = System.currentTimeMillis();

        System.out.println("Parallel Sum: " + parallelSum);
        System.out.println("Time Taken (Parallel): " + (endTime - startTime) + "ms");

        // Sequential sum for comparison
        startTime = System.currentTimeMillis();
        int sequentialSum = sequentialSum(numbers);
        endTime = System.currentTimeMillis();

        System.out.println("Sequential Sum: " + sequentialSum);
        System.out.println("Time Taken (Sequential): " + (endTime - startTime) + "ms");
    }

    private static int sequentialSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    private static int parallelSum(int[] numbers) throws InterruptedException {
        int partSize = SIZE / THREADS;
        SumThread[] threads = new SumThread[THREADS];
        int[] partialSums = new int[THREADS];

        for (int i = 0; i < THREADS; i++) {
            final int index = i;
            threads[i] = new SumThread(numbers, i * partSize, (i + 1) * partSize, partialSums, index);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join(); // Wait for all threads to finish
        }

        int totalSum = 0;
        for (int sum : partialSums) {
            totalSum += sum;
        }

        return totalSum;
    }
}
