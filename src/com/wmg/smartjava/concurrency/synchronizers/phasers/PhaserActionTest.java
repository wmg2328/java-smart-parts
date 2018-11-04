package com.wmg.smartjava.concurrency.synchronizers.phasers;

public class PhaserActionTest {

    public static void main(String[] args) {

        CustomPhaser customPhaser = new CustomPhaser();

        // Register the main thread as a party.
        customPhaser.register();

        System.out.println(String.format("#1: isTerminated(): %s", customPhaser.isTerminated()));

        // Arrival will advance the phaser and registered parties reduces to zero.
        customPhaser.arriveAndDeregister();

        // Trigger another phaser
        customPhaser.register();
        customPhaser.arriveAndDeregister();

        System.out.println(String.format("#2: isTerminated(): %s", customPhaser.isTerminated()));

        customPhaser.forceTermination();

        // Now phaser is terminated
        System.out.println(String.format("#3: isTerminated(): %s", customPhaser.isTerminated()));

    }
}
