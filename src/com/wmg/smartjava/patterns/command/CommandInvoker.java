package com.wmg.smartjava.patterns.command;

public class CommandInvoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void run() {
        this.command.execute();
    }
}
