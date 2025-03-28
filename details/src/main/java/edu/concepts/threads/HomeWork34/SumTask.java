package edu.concepts.threads.HomeWork34;

class SumThread extends Thread {
    private final int[] chisla;
    private final int start, end;
    private final int[] chastSum;
    private final int index;

    public SumThread(int[] chisla, int start, int end, int[] chastSum, int index) {
        this.chisla = chisla;
        this.start = start;
        this.end = end;
        this.chastSum = chastSum;
        this.index = index;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += chisla[i];
        }
        chastSum[index] = (int) sum;
    }
}
