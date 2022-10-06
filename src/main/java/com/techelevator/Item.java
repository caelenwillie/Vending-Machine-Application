package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String code;
    private String snack;
    private String price;
    private String category;

    public Item(String code, String snack, String price, String category) {
        this.code = code;
        this.snack = snack;
        this.price = price;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
