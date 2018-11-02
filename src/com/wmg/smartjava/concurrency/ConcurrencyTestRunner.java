package com.wmg.smartjava.concurrency;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Wiraj on 11/2/18 1:44 PM.
 * Project: java-smart-parts
 */
public class ConcurrencyTestRunner {

    public static void main(String[] args) {

        // Run Runnable
        TestRunnable testRunnable = new TestRunnable();
        testRunnable.run();

        // Single thread executor
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(testRunnable);

        //File file = new File()
    }
}
