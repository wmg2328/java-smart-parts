package com.wmg.smartjava.concurrency;

/**
 * Created by Wiraj on 11/2/18 1:44 PM.
 * Project: java-smart-parts
 */
public class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Starting -> " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done -> " + Thread.currentThread().getName());
    }
}
