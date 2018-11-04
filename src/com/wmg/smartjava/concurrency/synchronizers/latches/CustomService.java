package com.wmg.smartjava.concurrency.synchronizers.latches;

import java.util.concurrent.CountDownLatch;

public class CustomService implements Runnable {

    private CountDownLatch latch;

    public CustomService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            System.out.println(String.format("%s Waiting for %s to start", CustomService.class.getSimpleName(), LatchHelperService.class.getSimpleName()));
            latch.await();
            System.out.println(String.format("%s has started", CustomService.class.getSimpleName()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
