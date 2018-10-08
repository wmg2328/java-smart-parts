package com.wmg.smartjava.patterns.singleton;

public class DoubleLockCheckingSingleton {

    private static DoubleLockCheckingSingleton INSTANCE;

    private DoubleLockCheckingSingleton() {
    }

    public static DoubleLockCheckingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleLockCheckingSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleLockCheckingSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
