package org.example.patterns.decorator;

public class PepperoniPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Pepperoni pizza";
    }

    @Override
    public double getCost() {
        return 10;
    }
}
