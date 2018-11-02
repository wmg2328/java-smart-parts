package com.wmg.smartjava.concurrency.synchronizers.barriers;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SampleBarrier implements Runnable {

    private int id;
    private CyclicBarrier barrier;
    private static Random RANDOM = new Random();

    public SampleBarrier(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            int waitTime = RANDOM.nextInt(20) + 1;

            System.out.println(String.format("Thread # %s is working for %s seconds.", this.id, waitTime));

            Thread.sleep(waitTime * 1000);

            System.out.println(String.format("Thread # %s is waiting at barrier.", this.id));

            // wait for other thread in group to arrive
            this.barrier.await();

            System.out.println(String.format("Thread # %s is passed the barrier.", this.id));

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
