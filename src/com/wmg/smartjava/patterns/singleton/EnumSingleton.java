package com.wmg.smartjava.patterns.singleton;

/**
 * If this EnumSingleton is serialized, field variables are not getting serialized.
 * https://docs.oracle.com/javase/6/docs/platform/serialization/spec/serial-arch.html#6469
 */
public enum EnumSingleton {
    INSTANCE;

    int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
