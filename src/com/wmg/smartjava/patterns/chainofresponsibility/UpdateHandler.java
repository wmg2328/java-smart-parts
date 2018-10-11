package com.wmg.smartjava.patterns.chainofresponsibility;

public interface UpdateHandler {

    void setNextProcessHandler(UpdateHandler nextProcessHandler);

    boolean process(OSUpdateFileData osUpdateFileData);
}
