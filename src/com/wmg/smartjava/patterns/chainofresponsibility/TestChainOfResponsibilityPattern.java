package com.wmg.smartjava.patterns.chainofresponsibility;

import com.wmg.smartjava.patterns.chainofresponsibility.handlers.OSApplicationUpdateHandler;
import com.wmg.smartjava.patterns.chainofresponsibility.handlers.OSPatchUpdateHandler;
import com.wmg.smartjava.patterns.chainofresponsibility.handlers.OSUpdateHandler;

public class TestChainOfResponsibilityPattern {

    public static void main(String[] args) {

        // This object will go through predefined chain process and add any available updates
        OSUpdateFileData data = new OSUpdateFileData();

        // Defining the chain of handlers
        OSUpdateHandler osHandler = new OSUpdateHandler();
        OSPatchUpdateHandler osPatchHandler = new OSPatchUpdateHandler();
        OSApplicationUpdateHandler osApplicationHandler = new OSApplicationUpdateHandler();

        // Set the order of handlers
        osHandler.setNextProcessHandler(osPatchHandler);
        osPatchHandler.setNextProcessHandler(osApplicationHandler);

        // Process data with handler chain
        osHandler.process(data);

        System.out.println(data);


    }
}
