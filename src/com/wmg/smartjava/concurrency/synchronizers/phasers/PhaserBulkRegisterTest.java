package com.wmg.smartjava.concurrency.synchronizers.phasers;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

public class PhaserBulkRegisterTest {

    public static void main(String[] args) {

        Phaser phaser = new Phaser();

        // create tasks
        final int taskCount = 4;

        phaser.bulkRegister(taskCount);

        Executor executor = Executors.newCachedThreadPool();
        
        IntStream.rangeClosed(1, taskCount).iterator().forEachRemaining((Integer integer) -> {
            SimpleTask task = new SimpleTask(phaser, "Task # ".concat(String.valueOf(integer)));
            executor.execute(task);
        });
    }
}
