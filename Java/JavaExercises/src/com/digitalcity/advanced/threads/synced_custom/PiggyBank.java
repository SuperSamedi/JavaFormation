package com.digitalcity.advanced.threads.synced_custom;

public class PiggyBank {
    private int balance;


    public PiggyBank() {
        this.balance = 0;
    }


    public int getBalance() {
        return balance;
    }

    public void addMoney(int amount) {
        synchronized ( this ){
            balance += amount;
        }
//        balance += amount;
    }
}
