package com.wmg.smartjava.concurrency.locks.patterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPattern {

    static Lock lock = new ReentrantLock();
    static Condition isFull = lock.newCondition();
    static Condition isEmpty = lock.newCondition();

    static LinkedList<Integer> buffer = new LinkedList<>();
    private static final short CAPACITY = 4;
    private static int VALUE = 1;

    public static void main(String[] args) {

        List<Producer> producerList = new ArrayList<>(CAPACITY);
        List<Consumer> consumerList = new ArrayList<>(CAPACITY);
        List<Callable<String>> allProducerConsumerList = new ArrayList<>(CAPACITY * 2);

        for (int i = 0; i < CAPACITY; i++) {
            producerList.add(new Producer());
        }
        for (int i = 0; i < CAPACITY; i++) {
            consumerList.add(new Consumer());
        }

        allProducerConsumerList.addAll(producerList);
        allProducerConsumerList.addAll(consumerList);

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        try {
            List<Future<String>> futures = executorService.invokeAll(allProducerConsumerList);

            futures.forEach(f -> {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            System.out.println("Executor service shutdown");
        }

    }

    static class Producer implements Callable<String> {

        @Override
        public String call() throws Exception {
            try {
                lock.lock();

                while (buffer.size() == CAPACITY) {
                    isFull.await();
                }

                buffer.add(VALUE++);

                isEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return "Produced -> " + VALUE;
        }
    }

    static class Consumer implements Callable<String> {

        @Override
        public String call() throws Exception {
            try {
                lock.lock();

                while (buffer.size() == 0) {
                    isEmpty.await();
                }
                isFull.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return "Consumed -> " + buffer.removeFirst();
        }
    }
}
