package org.example.patterns.builder;

public class Car {

    public Car()
    {
    }
    private String body;
    private String color;
    private String interior;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body='" + body + '\'' +
                ", color='" + color + '\'' +
                ", interior='" + interior + '\'' +
                '}';
    }
}
