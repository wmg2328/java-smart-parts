package com.wmg.smartjava.patterns.factory;

public class FactoryRunner {

    public static void main(String[] args) {
        CarFactory.buildCar(CarType.ECONOMICAL);
        CarFactory.buildCar(CarType.HYBRID);
        CarFactory.buildCar(CarType.LUXURY);
    }
}
