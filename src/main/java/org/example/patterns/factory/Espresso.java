package org.example.patterns.factory;

public class Espresso extends CoffeeBase {
    @Override
    public void makeCoffee() {
        System.out.println("Espresso");
    }
}
