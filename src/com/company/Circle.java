package com.company;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double readius, String color) {
        this.radius = readius;
        this.color = color;
    }

    public double getReadius() {
        return radius;
    }
    public String getColor() {
        return color;
    }

    public void setReadius(double radius) {
        this.radius = radius;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "readius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
    double getArea()
    {
        return Math.PI*radius*radius;
    }
}
