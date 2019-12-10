package com.company;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Minibus());
        Random random = new Random();
        for(int i = 1; i <= 20; ++i){
            new Thread(new Human(cyclicBarrier)).start();
            try {
                Thread.sleep(random.nextInt(3000)+1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
