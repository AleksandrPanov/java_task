package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        Circle circle = new Circle(2, "green");
        MyTriangle triangle = new MyTriangle(new MyPoint(0, 0), new MyPoint(4, 0), new MyPoint(0, 3));
        System.out.println(circle);
        System.out.println(circle.getArea());
        System.out.println(triangle);
        System.out.println(triangle.getType());
        System.out.println(triangle.getPerimeter());

        Author aut[] = new Author[3];
        for (int i = 0; i < 3; i++)
            aut[i] = new Author("a".concat(String.valueOf(i)), "e".concat(String.valueOf(i)), 'm' );
        Book book = new Book("book1", aut, 150.0, 100);
        System.out.println(book);
        System.out.println(book.getAuthorNames());
    }
}
