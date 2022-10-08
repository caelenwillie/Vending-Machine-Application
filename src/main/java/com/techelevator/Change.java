package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Change extends Balance {
    private int change;

    public Change(int change) {
        this.change = change;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int maxCoinCount(double balance, double coin) {
        int count = (int) (balance / coin);
        return count;
    }

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
        changePrintOut = "You're change is: " + quarterCount + "quarters, " + dimeCount + "dimes, " + nickleCount + "nickles";
        return changePrintOut;
    }
}