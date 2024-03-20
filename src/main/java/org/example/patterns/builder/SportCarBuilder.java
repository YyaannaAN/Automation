package org.example.patterns.builder;

public class SportCarBuilder implements CarBuilder {

private  String body;
private String color;
private  String interior;

    @Override
    public CarBuilder withBody() {

        this.body ="Sport body";
        return this;
    }

    @Override
    public CarBuilder withColor() {
        this.color ="Red color";
        return this;
    }

    @Override
    public CarBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarBuilder withInterior() {
        this.interior ="Sport interior";
        return this;
    }

    @Override
    public Car build() {
        Car car = new Car();
        car.setBody(body);
        car.setColor(color);
        car.setInterior(interior);

        return car;
    }
}
