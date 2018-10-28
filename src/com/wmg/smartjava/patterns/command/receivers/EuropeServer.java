package com.wmg.smartjava.patterns.command.receivers;

public class EuropeServer implements Receiver {

    public static final String SERVER_NAME = "Europe Server";

    @Override
    public void connect() {
        System.out.println(String.format("%s is connected", SERVER_NAME));
    }

    @Override
    public void shutdown() {
        System.out.println(String.format("%s is shutdown", SERVER_NAME));
    }

    @Override
    public void test() {
        System.out.println(String.format("%s is tested", SERVER_NAME));
    }

    @Override
    public void restart() {
        System.out.println(String.format("%s is restarted", SERVER_NAME));
    }

    @Override
    public void disconnect() {
        System.out.println(String.format("%s is disconnected\n", SERVER_NAME));
    }
}
