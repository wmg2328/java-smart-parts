package com.wmg.smartjava.concurrency.synchronizers.phasers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

public class AdderTaskTest {

    public static void main(String[] args) {

        final int PHASER_COUNT = 1;

        Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {

                System.out.println(String.format("Phase: %s, Parties: %s, Arrived: %s", phase, registeredParties, this.getArrivedParties()));

                boolean terminatePhaser = false;

                if (phase >= PHASER_COUNT - 1 || registeredParties == 0) {
                    terminatePhaser = true;
                }

                return terminatePhaser;

            }
        };

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        // Create new tasks
        final int ADDER_TASK_COUNT = 10;

        // Register parties one more than number of adder tasks to synchronize to compute the result of
        // all generated integers by all adder tasks
        phaser.bulkRegister(ADDER_TASK_COUNT + 1);

        Executor executor = Executors.newCachedThreadPool();

        IntStream.rangeClosed(1, ADDER_TASK_COUNT).iterator().forEachRemaining((Integer integer) -> {
            String taskName = String.format("Task # %s", integer);
            AdderTask task = new AdderTask(taskName, phaser, list);
            executor.execute(task);
        });

        // Wait until phasers to terminate, then compute the sum of all generated integers by the adder task
        while (!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }

        // Now phaser is terminated. Compute the sum.
        System.out.println(String.format("Sum: %s", list.parallelStream().reduce(0, Integer::sum)));
    }
}
