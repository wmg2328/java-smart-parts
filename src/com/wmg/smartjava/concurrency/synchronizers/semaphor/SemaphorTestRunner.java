package com.wmg.smartjava.concurrency.synchronizers.semaphor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SemaphorTestRunner {
    public static void main(String[] args) {

        // Initialize hotel object with 10 rooms.
        Hotel hotel = new Hotel(5);

        Executor executor = Executors.newFixedThreadPool(5);

        // Create 20 visitors
        IntStream.rangeClosed(1, 20).iterator().forEachRemaining((Integer integer) -> {
            HotelVisitor hotelVisitor = new HotelVisitor(hotel, integer);
            executor.execute(hotelVisitor);
        });
    }
}
