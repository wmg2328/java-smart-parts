package com.wmg.smartjava.concurrency.synchronizers.semaphor;

import java.util.Random;

public class HotelVisitor implements Runnable {

    private Hotel hotel;
    private int visitorId;
    public static final Random RANDOM = new Random();

    public HotelVisitor(Hotel hotel, int visitorId) {
        this.hotel = hotel;
        this.visitorId = visitorId;
    }

    @Override
    public void run() {

        hotel.getRoom(this.visitorId);

        try {
            // set random spending dates for visitor
            int days = RANDOM.nextInt(5) + 1;
            System.out.println(String.format("Visitor # %s will spend %s days.", this.visitorId, days));

            Thread.sleep(days * 1000);

            System.out.println(String.format("Visitor # %s is about to checkout.", this.visitorId));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            hotel.checkoutRoom(this.visitorId);
        }
    }
}
