package com.gmail.babanin.aleksey;

import java.math.BigInteger;

public class SingleThreadArraySumm implements Runnable {
    private int[] array;
    private int begin;
    private int end;
    private BigInteger summ = new BigInteger("0");
    private Thread thr;

    public SingleThreadArraySumm(int[] array, int begin, int end) {
        super();
        this.array = array;
        this.begin = begin;
        this.end = end;
        thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run() {
        for (int i = begin; i < end; i += 1) {
            summ = summ.add(new BigInteger(Integer.toString(array[i])));
        }
    }

    public Thread getThr() {
        return thr;
    }

    public BigInteger getSumm() {
        return summ;
    }

}
