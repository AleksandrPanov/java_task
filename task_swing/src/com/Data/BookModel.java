package com.Data;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.Exception.MyExeptionDate;
import com.FileWorkers.*;
/**
 * Created by bola0814 on 14.12.2016.
 */
public class BookModel extends AbstractTableModel{

    private List<Book> books = new ArrayList<>();

    public BookModel() {
        books.add(new Book());
    }
    public BookModel(boolean empty){

    }
    public static void readData(BookModel bookModel)
    {

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
                        book.setPrice(Double.parseDouble(line));
                        break;
                    case 3:
                        book.setQty(Integer.parseInt(line));
                        break;
                    case 4:
                        book.setDate(line);
                        bookModel.addBook(book);
                        book = new Book();
                        break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        catch (MyExeptionDate e)
        {
            e.printStackTrace();
        }

    }
    public void writeData()
    {
        File file = new File("myFile.txt");
        try (FileWriter fr = new FileWriter(file)){
            for (Book b:books) {
                fr.write(b.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addBook(Book b){
        books.add(b);
        fireTableDataChanged();
    }
    public Book getBook(int row)
    {
        return books.get(row);
    }
    public boolean isBook(Book b)
    {
        return books.contains(b);
    }
    public void deleteRows(int ar[])
    {
        for (int i = 0; i < ar.length; i++) {
            books.remove(ar[i] - i);
        }
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book cur=books.get(rowIndex);
        switch (columnIndex){
            case 0:
                return cur.getName();
            case 1:
                return cur.getAuthor().toString();
            case 2:
                return cur.getPrice();
            case 3:
                return cur.getQty();
            case 4:
                return cur.getDate();
        }
        return null;
    }

    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Book name";
            case 1:
                return "Author";
            case 2:
                return "Price";
            case 3:
                return "Count";
            case 4:
                return "Date";
        }
        return "";
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Integer.class;
            case 4:
                return MyDate.class;
        }
        return Object.class;
    }
}
