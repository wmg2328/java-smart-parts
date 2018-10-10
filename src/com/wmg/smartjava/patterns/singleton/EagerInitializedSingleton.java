package com.wmg.smartjava.patterns.singleton;

/**
 * clone() method can be override to prevent this singleton cloning.
 */
public class EagerInitializedSingleton {

    private static volatile EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
