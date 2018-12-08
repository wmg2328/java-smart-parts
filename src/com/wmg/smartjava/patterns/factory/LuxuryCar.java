package com.wmg.smartjava.patterns.factory;

public class LuxuryCar extends Car {

    public LuxuryCar() {
        super(CarType.LUXURY);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println(String.format("Building %s car.", CarType.LUXURY.toString()));
    }
}
