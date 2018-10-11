package com.wmg.smartjava.patterns.chainofresponsibility;

public class OSUpdateFileData {

    private String OSUpdateData;
    private String OSPatchUpdateData;
    private String OSApplicationUpdateData;

    public String getOSUpdateData() {
        return OSUpdateData;
    }

    public void setOSUpdateData(String OSUpdateData) {
        this.OSUpdateData = OSUpdateData;
    }

    public String getOSPatchUpdateData() {
        return OSPatchUpdateData;
    }

    public void setOSPatchUpdateData(String OSPatchUpdateData) {
        this.OSPatchUpdateData = OSPatchUpdateData;
    }

    public String getOSApplicationUpdateData() {
        return OSApplicationUpdateData;
    }

    public void setOSApplicationUpdateData(String OSApplicationUpdateData) {
        this.OSApplicationUpdateData = OSApplicationUpdateData;
    }

    @Override
    public String toString() {
        return "OSUpdateFileData{" +
                "OSUpdateData='" + OSUpdateData + '\'' +
                ", OSPatchUpdateData='" + OSPatchUpdateData + '\'' +
                ", OSApplicationUpdateData='" + OSApplicationUpdateData + '\'' +
                '}';
    }
}
