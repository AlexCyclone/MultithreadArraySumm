package com.gmail.babanin.aleksey;

public class Main {
    public static void main(String[] args) {
        int size = 100000000;
        int[] array = new int[size];
        for (int i = 0; i < size; i += 1) {
            array[i] = i;
        }

        calculate(array, 1);
        calculate(array, 2);
        calculate(array, 4);
        calculate(array, 8);
        calculate(array, 16);
        calculate(array, 32);
        calculate(array, 64);

    }

    public static void calculate(int[] array, int threads) {
        long start = System.currentTimeMillis();
        MultithreadArraySumm.summ(array, threads);
        long finish = System.currentTimeMillis();

        System.out.println(finish - start + " ms - " + threads + " thread(s)");
    }
}
