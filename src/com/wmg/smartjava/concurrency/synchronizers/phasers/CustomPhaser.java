package com.wmg.smartjava.concurrency.synchronizers.phasers;

import java.util.concurrent.Phaser;

public class CustomPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {

        System.out.println(String.format("Method OnAdvance: phase : %s, registered parties = %s ", phase, registeredParties));

        // Do not return and continue with other Phasers if available
        return false;
    }
}
