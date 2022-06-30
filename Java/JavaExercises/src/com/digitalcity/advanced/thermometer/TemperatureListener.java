package com.digitalcity.advanced.thermometer;

public interface TemperatureListener {
    void reaction(int tempDelta, int newTemp);
}