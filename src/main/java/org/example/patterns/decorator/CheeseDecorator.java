package org.example.patterns.decorator;

public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza)
    {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "+ cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 3.00;
    }
}
