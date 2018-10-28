package com.wmg.smartjava.patterns.command;

import com.wmg.smartjava.patterns.command.receivers.Receiver;

public class TestCommand implements Command {

    private Receiver receiver;

    public TestCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.connect();
        receiver.test();
        receiver.disconnect();
    }
}
