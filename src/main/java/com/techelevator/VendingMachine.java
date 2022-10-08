package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    public static List<Item> importItems() {
        List<Item> items = new ArrayList<>();
        File itemFile = new File("vendingmachine.csv");
        String[] itemInfo = new String[4];

        try (Scanner fileScanner = new Scanner(itemFile)) {
            while (fileScanner.hasNextLine()) {
                String itemLine = fileScanner.nextLine();
                itemInfo = itemLine.split("\\|");

                Item item = new Item(itemInfo[0], itemInfo[1], Double.parseDouble(itemInfo[2]), itemInfo[3]);
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, vending machine temporarily out of service");
        }
        return items;
    }

    public String printItems() {
        String itemsPrintOut = "";
        for (int i =0; i < importItems().size(); i++) {
            itemsPrintOut += importItems().get(i).getCode() + " " + importItems().get(i).getName() + " " + importItems().get(i).getPrice() + " " + importItems().get(i).getCategory() + " (" + importItems().get(i).getCount() + " still remaining)\n";
        }
        return itemsPrintOut;
    }
}

//for (int i =0; i < importItems().size(); i++) {
//        System.out.println(importItems().get(i).getCode() + " " + importItems().get(i).getName() + " " + importItems().get(i).getPrice() + " " + importItems().get(i).getCategory() + " (" + importItems().get(i).getCount() + " still remaining)");

