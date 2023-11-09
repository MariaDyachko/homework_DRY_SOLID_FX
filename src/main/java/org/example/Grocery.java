package org.example;

public class Grocery extends Product implements Expirable{
    int DaysToExpire = 0;
    String name;
    int Price;

    public Grocery(String name, int price, int DaysToExpire) {
        this.DaysToExpire = DaysToExpire;
        this.name = name;
        Price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return Price;
    }
}
