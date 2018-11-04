package com.wmg.smartjava.concurrency;

import java.io.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConcurrencyTestRunner {

    public static void main(String[] args) {

        // Run Runnable
//        TestRunnable testRunnable = new TestRunnable();
//        testRunnable.run();
//
//        // Single thread executor
//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(testRunnable);

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("db.txt"))) {
            dataOutputStream.writeChars("Test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
