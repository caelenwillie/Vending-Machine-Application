package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Balance {

    private double balance = 0.00;
    Scanner userInput = new Scanner(System.in);

    public double getBalance() {
        return balance;
    }

    public void addToBalance(double moneyToAdd) {
        balance = balance + moneyToAdd;
    }

    public void removeFromBalance(double snackPrice) {
        balance = balance - snackPrice;
    }

//    public double collectMoney() {
//        System.out.println("How much money would you like to input? ");
//        double additionalFunds = userInput.nextDouble();
//        return additionalFunds;
//    }

    public String changeCalculator(double balance) {
        double quarter = 0.25;
        int quarterCount = 0;
        double dime = 0.10;
        int dimeCount = 0;
        double nickle = 0.05;
        int nickleCount = 0;
        double balanceRemaining = 0;
        List<Integer> changeBack = new ArrayList<>();
        String changePrintOut = "";

        if (balance > 0) {
            quarterCount = (int) (balance / quarter);
            if (balance % quarter != 0) {
                balanceRemaining = balance % quarter;
                dimeCount = (int) (balanceRemaining / dime);
                if (balanceRemaining % dime != 0) {
                    balanceRemaining = balanceRemaining % dime;
                    nickleCount = (int) (balanceRemaining / nickle);
                }
            }
        }
        changePrintOut = "You're change is: " + quarterCount + " quarters, " + dimeCount + " dimes, " + nickleCount + " nickles";
        return changePrintOut;
    }


}