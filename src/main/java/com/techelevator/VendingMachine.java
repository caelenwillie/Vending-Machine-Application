package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    public List<Item> importItems() {
        List<Item> items = new ArrayList<>();
        File itemFile = new File("vendingmachine.csv");
        String[] itemInfo = new String[4];

        try(Scanner fileScanner = new Scanner(itemFile)) {
            while(fileScanner.hasNextLine()) {
                String itemLine = fileScanner.nextLine();
                itemInfo = itemLine.split("\\|");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found - Vending machine temporarily out of service");
        }


    }

}

// ["A1", "Potato Crisps", "3.05", "Chip"]