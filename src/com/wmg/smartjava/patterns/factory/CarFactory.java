package com.wmg.smartjava.patterns.factory;

public class CarFactory {

    public static Car buildCar(CarType carType) {

        Car car = null;

        switch (carType) {
            case ECONOMICAL:
                car = new EconomicalCar();
                break;
            case HYBRID:
                car = new HybridCar();
                break;
            case LUXURY:
                car = new LuxuryCar();
                break;
        }

        return car;
    }
}
