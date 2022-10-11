package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Balance {

    private double balance = 0.00;
    private Integer[] acceptablePayments = {1, 5, 10, 20};

    Scanner userInput = new Scanner(System.in);

    public double getBalance() {
        return balance;
    }

    public Integer[] getAcceptablePayments() {
        return acceptablePayments;
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
        String quarterString = "";
        String nickleString = "";
        String dimeString = "";

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
        if (quarterCount == 1) {
            quarterString = "quarter";
        } else {
            quarterString = "quarters";
        }
        if (dimeCount == 1) {
            dimeString = "dime";
        } else {
            dimeString = "dimes";
        }
        if (nickleCount == 1) {
            nickleString = "nickle";
        } else {
            nickleString = "nickles";
        }
        changePrintOut = "You're change is: " + quarterCount + " " + quarterString + ", " + dimeCount + " " + dimeString + ", " + nickleCount + " " + nickleString;
        return changePrintOut;
    }

    //TEST METHODS
    public void addToBalance2(double moneyToAdd) {
        balance = balance + moneyToAdd;
    }
}