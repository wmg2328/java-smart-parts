package com.wmg.smartjava.concurrency.synchronizers.latches;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class LatchHelperService implements Runnable {

    private int id;
    private CountDownLatch latch;
    private static Random RANDOM = new Random();

    public LatchHelperService(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            int setUpTime = RANDOM.nextInt(10) + 1;
            System.out.println(String.format("%s #%s starting in %s seconds", LatchHelperService.class.getSimpleName(), id, setUpTime));
            Thread.sleep(setUpTime * 1000);
            System.out.println(String.format("%s #%s has started", LatchHelperService.class.getSimpleName(), id));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.latch.countDown();
        }
    }
}
