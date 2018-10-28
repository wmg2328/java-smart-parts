package com.wmg.smartjava.patterns.command;

import com.wmg.smartjava.patterns.command.receivers.Receiver;

public class RestartCommand implements Command {

    private Receiver receiver;

    public RestartCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.connect();
        receiver.restart();
        receiver.disconnect();
    }
}
