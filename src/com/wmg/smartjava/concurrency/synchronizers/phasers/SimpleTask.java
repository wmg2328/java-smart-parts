package com.wmg.smartjava.concurrency.synchronizers.phasers;

import java.util.Random;
import java.util.concurrent.Phaser;

public class SimpleTask implements Runnable {

    private Phaser phaser;
    private String taskName;
    private static Random RANDOM = new Random();

    public SimpleTask(Phaser phaser, String taskName) {
        this.phaser = phaser;
        this.taskName = taskName;
    }

    @Override
    public void run() {

        System.out.println(String.format("Task # %s is initializing.", this.taskName));

        int sleepTime = RANDOM.nextInt(10) + 1;
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("Task # %s is initialized.", this.taskName));

        phaser.arriveAndAwaitAdvance();

        System.out.println(String.format("Task # %s is started.", this.taskName));

    }
}
