package com.wmg.smartjava.patterns.singleton;

import java.io.Serializable;

public class SerializedSingleton implements Serializable {

    private static SerializedSingleton INSTANCE;

    private SerializedSingleton() {
    }

    public static SerializedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SerializedSingleton();
        }
        return INSTANCE;
    }

    /**
     * This method is called immediately when an object of this class is de-serialized
     */
    protected Object readResolve() {
        return INSTANCE;
    }
}
