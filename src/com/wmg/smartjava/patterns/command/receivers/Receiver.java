package com.wmg.smartjava.patterns.command.receivers;

public interface Receiver {

    void connect();

    void shutdown();

    void test();

    void restart();

    void disconnect();

}
