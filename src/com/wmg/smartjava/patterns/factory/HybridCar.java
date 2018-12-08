package com.wmg.smartjava.patterns.factory;

public class HybridCar extends Car {

    public HybridCar() {
        super(CarType.HYBRID);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println(String.format("Building %s car.", CarType.HYBRID.toString()));
    }
}
