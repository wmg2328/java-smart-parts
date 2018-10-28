package com.wmg.smartjava.patterns.command;

import com.wmg.smartjava.patterns.command.receivers.AsiaServer;
import com.wmg.smartjava.patterns.command.receivers.EuropeServer;
import com.wmg.smartjava.patterns.command.receivers.UsaServer;

public class TestCommandPattern {

    public static void main(String[] args) {
        // Convert commands into an object with predefined order
        CommandInvoker invoker = new CommandInvoker();

        // Receivers
        AsiaServer asiaServer = new AsiaServer();
        UsaServer usaServer = new UsaServer();
        EuropeServer europeServer = new EuropeServer();

        // Commands
        ShutdownCommand shutdownEuropeCommand = new ShutdownCommand(europeServer);
        invoker.setCommand(shutdownEuropeCommand);
        invoker.run();

        TestCommand testUsaCommand = new TestCommand(usaServer);
        invoker.setCommand(testUsaCommand);
        invoker.run();

        RestartCommand restartAsia = new RestartCommand(asiaServer);
        invoker.setCommand(restartAsia);
        invoker.run();
    }
}
