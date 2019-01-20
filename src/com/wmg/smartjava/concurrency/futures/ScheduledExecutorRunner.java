package com.wmg.smartjava.concurrency.futures;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorRunner {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("This is called at " + LocalDateTime.now().toString());
        };

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(runnable, 1000, 4000, TimeUnit.MILLISECONDS);
    }
}
