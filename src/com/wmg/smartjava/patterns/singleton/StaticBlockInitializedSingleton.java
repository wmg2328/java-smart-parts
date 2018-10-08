package com.wmg.smartjava.patterns.singleton;

public class StaticBlockInitializedSingleton {

    private static StaticBlockInitializedSingleton INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockInitializedSingleton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private StaticBlockInitializedSingleton() {
    }

    public static StaticBlockInitializedSingleton getInstance() {
        return INSTANCE;
    }
}
