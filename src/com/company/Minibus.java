package com.company;

import java.util.concurrent.CyclicBarrier;

public class Minibus implements Runnable {

    public Minibus(){
    }

    @Override
    public void run() {
        try {
            System.out.println("Minibus start moving");
            Thread.sleep(5000);
            System.out.println("Minibus has finished moving");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
