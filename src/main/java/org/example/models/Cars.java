package org.example.models;

import java.util.Objects;

public class Cars {

    public String getColor() {
        return color;
    }
    public Double getEngine() {
        return engine;
    }
    private final String color;
    private final Double engine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(color, cars.color) && Objects.equals(engine, cars.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, engine);
    }

    public Cars(String color, Double engine)
    {
        this.color = color;
        this.engine = engine;
    }
}
