package com.wmg.smartjava.patterns.singleton;

public class EagerInitializedSingleton {

    private static volatile EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return INSTANCE;
    }
}
