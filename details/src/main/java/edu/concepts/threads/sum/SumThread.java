package edu.concepts.threads.sum;

class SumThread extends Thread {
    private final int[] numbers;
    private final int start, end;
    private final int[] partialSums;
    private final int index;

    public SumThread(int[] numbers, int start, int end, int[] partialSums, int index) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.partialSums = partialSums;
        this.index = index;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        partialSums[index] = sum; // Store the result
    }
}
