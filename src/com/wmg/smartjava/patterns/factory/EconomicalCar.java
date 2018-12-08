package com.wmg.smartjava.patterns.factory;

public class EconomicalCar extends Car {

    public EconomicalCar() {
        super(CarType.ECONOMICAL);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println(String.format("Building %s car.", CarType.ECONOMICAL.toString()));
    }
}
