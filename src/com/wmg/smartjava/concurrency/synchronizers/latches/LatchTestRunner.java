package com.wmg.smartjava.concurrency.synchronizers.latches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LatchTestRunner {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Executor executor = Executors.newCachedThreadPool();
        CustomService customService = new CustomService(countDownLatch);
        executor.execute(customService);

        IntStream.rangeClosed(1, 2).iterator().forEachRemaining((Integer integer) -> {
            LatchHelperService latchHelperService = new LatchHelperService(integer, countDownLatch);
            executor.execute(latchHelperService);
        });
    }
}
