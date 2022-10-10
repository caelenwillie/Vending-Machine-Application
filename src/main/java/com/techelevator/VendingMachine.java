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

                Item item = new Item(itemInfo[0], itemInfo[1], Double.parseDouble(itemInfo[2]), itemInfo[3], "5");
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, vending machine temporarily out of service");
        }
        return items;
    }

    public void printItems(List<Item> products) {

        for (int i = 0; i < products.size(); i++) {
            if (Integer.parseInt(products.get(i).getCount()) > 0) {
                System.out.printf("%s %-20s $%-7.2f %-7s %d items Left %n", products.get(i).getCode(), products.get(i).getName(), products.get(i).getPrice(), products.get(i).getCategory(), Integer.parseInt(products.get(i).getCount()));
            } else {
                System.out.printf("%s %-20s $%-7.2f %-7s SOLD OUT %n", products.get(i).getCode(), products.get(i).getName(), products.get(i).getPrice(), products.get(i).getCategory());
            }
            }
        }
    }
