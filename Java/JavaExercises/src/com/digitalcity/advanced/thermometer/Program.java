package com.digitalcity.advanced.thermometer;


public class Program {
    public static void main(String[] args) {

        TemperatureListener onTempUp = (tempDelta, newTemp) -> System.out.printf("Temperatures went up by %s degrees. It is now %s degrees.\n", tempDelta, newTemp);
        TemperatureListener onTempDown = (tempDelta, newTemp) -> System.out.printf("Temperatures went down by %s degrees. It is now %s degrees.\n", tempDelta, newTemp);

        Thermometer thermometer = new Thermometer(0);

        thermometer.subTemperatureUp(onTempUp);
        thermometer.subTemperatureDown(onTempDown);

        thermometer.setTemperature(5);
        thermometer.setTemperature(-10);


    }
}