package com.wmg.smartjava.patterns.mediator;

public class TestMediatorPattern {

    public static void main(String[] args) {

        ApplicationMediator mediator = new ApplicationMediator();
        mediator.getWelcomePage().navigate();
    }
}
