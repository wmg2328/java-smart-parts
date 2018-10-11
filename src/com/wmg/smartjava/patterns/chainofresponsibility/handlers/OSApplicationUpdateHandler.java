package com.wmg.smartjava.patterns.chainofresponsibility.handlers;

import com.wmg.smartjava.patterns.chainofresponsibility.OSUpdateFileData;
import com.wmg.smartjava.patterns.chainofresponsibility.UpdateHandler;

public class OSApplicationUpdateHandler implements UpdateHandler {

    private UpdateHandler updateHandler;

    @Override
    public void setNextProcessHandler(UpdateHandler nextProcessHandler) {
        this.updateHandler = nextProcessHandler;
    }

    @Override
    public boolean process(OSUpdateFileData osUpdateFileData) {
        osUpdateFileData.setOSApplicationUpdateData("OS application update is added");
        return updateHandler == null || updateHandler.process(osUpdateFileData);
    }
}
