package com.Data;
import com.Exception.ExeptionDate;
import com.Exception.ExeptionDateNotExist;
import com.Exception.MyExeptionDate;

import java.util.Date;

public class Book {
    private String name;
    private Author author;
    private double price = 1.0;
    private int qty = 1;
    private MyDate date = new MyDate();

    public Book()
    {
        name = "book example name";
        author = new Author();
    }
    public Book(String ... arData) throws NumberFormatException, ExeptionDate, ExeptionDateNotExist
    {
        name = arData[0];
        author = new Author(arData[1]);
        price = Double.parseDouble(arData[2]);
        qty = Integer.parseInt(arData[3]);
        date = MyDate.pars(arData[4]);
        if (qty <= 0 || price <= 0.0) throw new NumberFormatException();
    }
    public Book(double price, Author author, String name) {
        this.price = price;
        this.author = author;
        this.name = name;
    }

    public Book(String name, int qty, double price, Author author) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }
    public MyDate getDate()
    {
        return date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setDate(String s) throws MyExeptionDate{
        this.date = MyDate.pars(s);
    }

    @Override
    public String toString() {
        return  name + "\r\n" +
                author + "\r\n" + price +
                "\r\n" + qty +
                "\r\n" + date + "\r\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!getName().equals(book.getName())) return false;
        if (!getAuthor().equals(book.getAuthor())) return false;
        return getDate().equals(book.getDate());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getDate().hashCode();
        return result;
    }
}