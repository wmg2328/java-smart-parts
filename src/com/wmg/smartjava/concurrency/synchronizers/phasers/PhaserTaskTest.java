package com.wmg.smartjava.concurrency.synchronizers.phasers;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

public class PhaserTaskTest {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);

        Executor executor = Executors.newCachedThreadPool();

        IntStream.rangeClosed(1, 5).iterator().forEachRemaining((Integer integer) -> {
            phaser.register();

            SimpleTask task = new SimpleTask(phaser, "Task # ".concat(String.valueOf(integer)));
            executor.execute(task);
        });

        phaser.arriveAndDeregister();
    }
}
