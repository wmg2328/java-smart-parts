package com.wmg.smartjava.concurrency.synchronizers.exchangers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerConsumer implements Runnable {

    private Exchanger<List<Integer>> exchanger;
    private static Random RANDOM = new Random();
    private List<Integer> buffer = new ArrayList<>();


    public ExchangerConsumer(Exchanger<List<Integer>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer is waiting for the data from producer.");

                buffer = exchanger.exchange(buffer);
                System.out.println("Consumer has received.");

                int sleepTime = RANDOM.nextInt(10) + 1;
                Thread.sleep(sleepTime);

                this.emptyBuffer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void emptyBuffer() {
        this.buffer.clear();
    }
}
