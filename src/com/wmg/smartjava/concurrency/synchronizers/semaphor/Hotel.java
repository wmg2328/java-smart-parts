package com.wmg.smartjava.concurrency.synchronizers.semaphor;

import java.util.concurrent.Semaphore;

/**
 * Semaphors is used to control the number of threads that can access to a resource
 */
public class Hotel {

    private Semaphore rooms;

    public Hotel(int roomCount) {
        this.rooms = new Semaphore(roomCount);
    }

    public void getRoom(int visitorId) {

        try {
            System.out.println(String.format("Visitor # %s is trying to book room.", visitorId));

            rooms.acquire();

            System.out.println(String.format("Visitor # %s got a room.", visitorId));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkoutRoom(int visitorId) {
        System.out.println(String.format("Visitor # %s check out from room.", visitorId));

        rooms.release();
    }
}
