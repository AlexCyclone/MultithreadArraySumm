package com.gmail.babanin.aleksey;

import java.math.BigInteger;

public class MultithreadArraySumm {
    static BigInteger summ(int[] array, int threadNumber) {
        BigInteger summ = new BigInteger("0");

        SingleThreadArraySumm[] threadSumm = new SingleThreadArraySumm[threadNumber];
        for (int i = 0; i < threadSumm.length; i += 1) {
            int size = array.length / threadNumber;
            int begin = i * size;
            int end = (i + 1) * size;
            if (i == threadSumm.length - 1) {
                end = array.length;
            }
            threadSumm[i] = new SingleThreadArraySumm(array, begin, end);
        }

        for (int i = 0; i < threadSumm.length; i += 1) {
            try {
                threadSumm[i].getThr().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (SingleThreadArraySumm threadSumms : threadSumm) {
            summ = summ.add(threadSumms.getSumm());
        }

        return summ;
    }
}
