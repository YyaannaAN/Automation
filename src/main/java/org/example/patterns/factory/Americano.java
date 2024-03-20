package org.example.patterns.factory;

public class Americano extends CoffeeBase {
    @Override
    public void makeCoffee() {
        System.out.println("Americano");
    }
}
