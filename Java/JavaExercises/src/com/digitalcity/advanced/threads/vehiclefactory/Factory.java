package com.digitalcity.advanced.threads.vehiclefactory;

import java.util.Random;
import java.util.Scanner;

public class Factory {
    private static Frame frame;
    private static WheelSet wheelSet;
    private static Engine engine;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean running = true;
        while (running) {
            Thread thFrame = new Thread(() -> {
                System.out.println("Starting new frame manufacture.");

                FrameType frameType = FrameType.values()[new Random().nextInt(FrameType.values().length)];

                try {
                    Thread.sleep(1500);
                    frame = new Frame(frameType);
                } catch (InterruptedException ex) {
                    System.out.println("Frame making has been interrupted.");
                }

                System.out.println("New frame finished.");
            });

            Thread thWheelSet = new Thread(() -> {
                System.out.println("Starting new wheel set manufacture.");
                wheelSet = new WheelSet();
                double diameter = (new Random().nextInt(6, 10) * 10 ) + (new Random().nextDouble(1));

                for (int i = 0; i < 4; i++) {
                    System.out.println("Starting wheel " + (i + 1) + " manufacture.");

                    try {
                        Thread.sleep(1000);
                        Wheel newWheel = new Wheel(diameter);
                        wheelSet.addWheel(i, newWheel);
                    } catch (InterruptedException ex) {
                        System.out.println("Wheel set making has been interrupted.");
                    }


                    System.out.println("New wheel added to the wheel set.");
                }
            });

            Thread thEngine = new Thread(() -> {
                System.out.println("Starting new engine manufacture.");

                int power = new Random().nextInt(5, 10) * 1000;
                if(power == 9000)
                    power++;

                try {
                    Thread.sleep(2000);
                    engine = new Engine(power);
                } catch (InterruptedException ex) {
                    System.out.println("Engine making has been interrupted.");
                }

                System.out.println("New engine finished.");
            });

            thFrame.start();
            thWheelSet.start();
            thEngine.start();

            try {
                thFrame.join();
                thWheelSet.join();
                thEngine.join();
                Vehicle newVehicle = new Vehicle(frame, wheelSet, engine);
                System.out.println(newVehicle);
            } catch (InterruptedException ex) {
                System.out.println("The joining of the threads has encountered an interruption.");
            }

            System.out.println();
            System.out.println();

            System.out.println("Manufacture a new vehicle?");
            scan.nextLine();
        }
    }

}
