package com.wmg.smartjava.concurrency.synchronizers.phasers;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * Created by Wiraj on 11/4/18 12:45 PM.
 * Project: java-smart-parts
 */
public class AdderTask implements Runnable {

    private String taskName;
    private Phaser phaser;
    private List<Integer> list;
    private static Random RANDOM = new Random();

    public AdderTask(String taskName, Phaser phaser, List<Integer> list) {
        this.taskName = taskName;
        this.phaser = phaser;
        this.list = list;
    }

    @Override
    public void run() {
        do {

            int generatedNum = RANDOM.nextInt(10) + 1;

            System.out.println(String.format("%s added %s", taskName, generatedNum));

            list.add(generatedNum);

            // Wait till other parties to arrive at the phaser
            phaser.arriveAndAwaitAdvance();

        } while (!phaser.isTerminated());
    }
}
