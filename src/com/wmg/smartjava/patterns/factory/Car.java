package com.wmg.smartjava.patterns.factory;

public abstract class Car {

    private CarType carType = null;

    public Car(CarType carType) {
        this.carType = carType;
    }

    protected abstract void construct();

    public CarType getCarType() {
        return carType;
    }
}
