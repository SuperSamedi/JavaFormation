package com.digitalcity.advanced.threads.vehiclefactory;


public class Frame {
    private final FrameType frameType;


    public Frame(FrameType frameType){
        this.frameType = frameType;
    }

    public FrameType getFrameType() {
        return frameType;
    }

    @Override
    public String toString() {
        return "Frame - " + "Type : " + frameType;
    }
}
