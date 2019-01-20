package com.wmg.smartjava.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTestClass {

    private static Lock lock = new ReentrantLock();
    private static Lock fairLock = new ReentrantLock(true);

    // Interruptable lock acquisition
    public static void interruptableLockAcquisition() {
        try {
            lock.lock();
            Thread.sleep(2000);
            System.out.println("Done execution " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // Timed lock acquisition
    public static void timedLockAcquisition() {
        if (lock.tryLock()) {
            try {
                Thread.sleep(2000);
                System.out.println("Done execution " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Method is locked. Wait");
        }
    }

    // Fair lock acquisition
    public static void fairLockAcqisition() {
        try {
            fairLock.lock();
            Thread.sleep(2000);
            System.out.println("Done execution " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            fairLock.unlock();
        }
    }

}
