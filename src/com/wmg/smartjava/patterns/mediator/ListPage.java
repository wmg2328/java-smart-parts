package com.wmg.smartjava.patterns.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListPage implements PageAction {

    private ApplicationMediator applicationMediator;

    public ListPage(ApplicationMediator applicationMediator) {
        this.applicationMediator = applicationMediator;
    }

    @Override
    public void navigate() {
        System.out.println("Do you want to select items? [y/n(or any other key)]");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String response = reader.readLine();
            if (response.equalsIgnoreCase("y")) {
                applicationMediator.handle("shop.checkout");
            } else {
                applicationMediator.handle("shop.exit");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
