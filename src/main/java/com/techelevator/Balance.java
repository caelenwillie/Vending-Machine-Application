package com.techelevator;

public class Balance {
    private double balance = 0.00;



    public double getBalance() {
        return balance;
    }

    public void setBalance(double giveMoney) {
        balance = balance + giveMoney;
    }

    public void completePurchase(double snackPrice) {
        balance = balance - snackPrice;
    }
}