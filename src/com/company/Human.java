package com.company;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Human implements Runnable {
    private static int count = 0;
    private int number;
    private CyclicBarrier cyclicBarrier;

    public Human(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
        this.number = ++count;
    }

    @Override
    public void run() {
        if(cyclicBarrier.getNumberWaiting() == cyclicBarrier.getParties()) {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Human with number "+number+" sat in the minibus.");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Human with number "+number+" got out of the minibus.");
    }
}
