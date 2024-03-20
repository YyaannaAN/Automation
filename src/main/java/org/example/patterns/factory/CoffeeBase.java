package org.example.patterns.factory;

public abstract class CoffeeBase {

    public void grindCoffee()
    {
        System.out.println("grind coffee");
    }

    public abstract void makeCoffee();

    public void pourIntoCup()
    {
        System.out.println("pour into cup");
    }
}
