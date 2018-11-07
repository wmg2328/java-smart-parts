package com.wmg.smartjava.concurrency.synchronizers.exchangers;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExchangerTestRunner {

    public static void main(String[] args) {

        try {
            Exchanger<List<Integer>> exchanger = new Exchanger<>();

            // The producer will create 10 integers on andy request
            ExchangerProducer producer = new ExchangerProducer(exchanger, 5);
            ExchangerConsumer consumer = new ExchangerConsumer(exchanger);

            Executor executor = Executors.newCachedThreadPool();

            executor.execute(producer);
            executor.execute(consumer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
