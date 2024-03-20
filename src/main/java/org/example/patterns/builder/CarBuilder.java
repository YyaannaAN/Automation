package org.example.patterns.builder;

public interface CarBuilder {
     CarBuilder withBody();
     CarBuilder withColor();
     CarBuilder withColor(String color);
     CarBuilder withInterior();
     Car build();
}
