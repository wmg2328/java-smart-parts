package com.wmg.smartjava.concurrency.futures;

import java.util.concurrent.*;

public class TestFutureRunner {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        Callable<String> stringCallable = () -> {
            Thread.sleep(2000);
            return "This is callable response " + Thread.currentThread().toString();
        };

        Callable<String> taskThrowsException = () -> {throw new IllegalStateException("Exception " + Thread.currentThread().getName());};

        Future<String> response1 = executor.submit(stringCallable);
        Future<String> response2 = executor.submit(taskThrowsException);

        try {
            System.out.println(response1.get());
            System.out.println(response2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}
