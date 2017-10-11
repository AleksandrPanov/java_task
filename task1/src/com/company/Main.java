package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        Circle circle = new Circle(2, "green");
        System.out.println(circle);
        System.out.println(circle.getArea());
    }
}
