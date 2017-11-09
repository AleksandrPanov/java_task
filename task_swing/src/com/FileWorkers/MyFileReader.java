package com.FileWorkers;
import com.Data.*;
import com.Exception.MyExeptionDate;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader{

    private List<Book> books;
    boolean f=false;

    public List<Book> getBooks(){
        f=false;
        return books;
    }

    public boolean isChanged(){
        return f;
    }


    protected void read(){
        try (BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"));){
            String line;
            Book book=new Book();
            for(int i=0; (line = reader.readLine()) != null;i++) {
                switch(i%5){
                    case 0:
                        book.setName(line);
                        break;
                    case 1:
                        book.setAuthor(new Author(line));
                        break;
                    case 2:
                        book.setDate(line);
                        break;
                    case 3:
                        book.setQty(Integer.parseInt(line));
                        books.add(book);
                        book = new Book();
                        break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (MyExeptionDate myExeptionDate) {
            myExeptionDate.printStackTrace();
        }
    }

    public void startReading(List<Book> books){
        this.books=books;
    }


}
