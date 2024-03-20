package org.example.patterns.factory;

public class CoffeeFactory {

    public static CoffeeBase orderCoffee(CoffeeType type)
    {
        CoffeeBase coffee =null;
        switch (type)
        {
            case LATTE -> coffee = new Latte();
            case ESPRESSO -> coffee =new Espresso();
            case AMERICANO -> coffee = new Americano();
        }

        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();

        return coffee;
    }
}
