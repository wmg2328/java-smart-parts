package com.wmg.smartjava.patterns.singleton;

public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        public static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
