package com.company;

import java.util.Arrays;

public class Book {
    private String name;
    private Author [] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        String s = "";
        for (Author a : authors)
        {
            s = s.concat(a.toString());
        }
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + s +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    String getAuthorNames()
    {
        String s = "";
        for (int i = 0; i < authors.length; i++)
          s = String.join(",", authors[i].name, s);
        return s;
    }
}
