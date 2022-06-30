package com.digitalcity.advanced.threads.synced_custom;



public class Allowance extends Thread{
    private PiggyBank piggyBank;
    private int amount;
    private float frequency; // in seconds
    private boolean running;

    public Allowance(PiggyBank piggyBank, int amount, float frequency){
        this.piggyBank = piggyBank;
        this.amount = amount;
        this.frequency = frequency;
        this.running = true;
    }

    @Override
    public void run() {
        try {
            while(running){
                Thread.sleep((long)(frequency * 1000l));
                piggyBank.addMoney(amount);
            }
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public void toggleAllowance() {
        running = !running;

        if (!running) {
            System.out.println("Allowance has been stopped.");
            return;
        }
            System.out.println("Allowance is running.");
    }
}
