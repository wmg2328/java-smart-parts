package com.wmg.smartjava.concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockRunner {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 4; i++) {
                //executorService.execute(LockTestClass::interruptableLockAcquisition);
                executorService.execute(LockTestClass::timedLockAcquisition);
                //executorService.execute(LockTestClass::fairLockAcquisition);
            }
        } finally {
            executorService.shutdown();
        }

    }
}
