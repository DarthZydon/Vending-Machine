package com.techelevator.view;

public class Product {

    public String name;
    public int price;
    public String category;
    public int count;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getCount() {
        return count;
    }

    public Product(String name, int price, String category, int count) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.count = count;
    }
}
