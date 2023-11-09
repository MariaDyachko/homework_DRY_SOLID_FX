package org.example;

public class Technique extends Product implements ReturnAble{

    String name;
    int Price;
    @Override
    public void goBack() {
        System.out.println("here you are your money");
    }

    public Technique(String name, int price) {
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
