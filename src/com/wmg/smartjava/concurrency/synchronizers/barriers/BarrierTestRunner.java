package com.wmg.smartjava.concurrency.synchronizers.barriers;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BarrierTestRunner {

    public static void main(String[] args) {

        // Group of thread at barrier and when pass given action is executed.
        Runnable runnable = () -> System.out.println("All are here. Let's cross the barrier");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, runnable);

        Executor executor = Executors.newCachedThreadPool();

        IntStream.rangeClosed(1, 5).iterator().forEachRemaining((Integer integer) -> {
            SampleBarrier barrier = new SampleBarrier(integer, cyclicBarrier);
            executor.execute(barrier);
        });
    }
}
