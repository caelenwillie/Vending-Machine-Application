package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String code;
    private String name;
    private double price;
    private String category;
    private int count = 5;

    public Item(String code, String name, double price, String category, int count) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
        this.count = 5;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
