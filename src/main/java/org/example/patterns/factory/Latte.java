package org.example.patterns.factory;

public class Latte extends CoffeeBase {

    @Override
    public void makeCoffee() {
        System.out.println("Latte");
    }
}
