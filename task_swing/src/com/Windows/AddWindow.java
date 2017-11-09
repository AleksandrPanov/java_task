package com.Windows;
import com.Exception.ExeptionDate;

import com.Data.Book;
import com.Data.BookModel;
import com.Exception.ExeptionDateNotExist;
import com.Exception.ExeptionThisBookExist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddWindow extends ChangeWindow
{
    protected JPanel textPan;
    protected JPanel grPan;
    protected JTextField textFields[];
    protected JLabel labels[];
    protected BookModel bookModel;
    public AddWindow()
    {
        super();
    }
    public AddWindow(JFrame frame, BookModel originalBookModel, String name)
    {
       this(frame, originalBookModel, name, new BookModel());
       setVisible(true);
    }
    public AddWindow(JFrame frame, BookModel originalBookModel, String name, BookModel bookModel)
    {
        //form
        super(frame, originalBookModel, name);
        textPan = new JPanel();
        add(textPan, BorderLayout.CENTER);
        grPan = new JPanel();
        textPan.add(grPan);
        //bookModel and txt fields and labs
        this.bookModel = bookModel;
        textFields = new JTextField[bookModel.getColumnCount()];
        labels = new JLabel[bookModel.getColumnCount()];
        grPan.setLayout(new GridLayout(2,bookModel.getColumnCount(), 2, 10));
        for (int i = 0; i < bookModel.getColumnCount(); i++)
        {
            labels[i] = new JLabel(bookModel.getColumnName(i));
            grPan.add(labels[i]);
        }
        for (int i = 0; i < bookModel.getColumnCount(); i++)
        {
            textFields[i] = new JTextField();
            grPan.add(textFields[i]);
        }
        fillTextFields();
        //button
        okButListener1(butOk);
    }
    protected void fillTextFields()
    {
        for (int i = 0; i < bookModel.getColumnCount(); i++)
        {
            textFields[i].setText(bookModel.getValueAt(0, i).toString());
        }
    }
    protected void okButListener1(JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String s[] = new String[bookModel.getColumnCount()];
                for (int i = 0; i <bookModel.getColumnCount(); i++ )
                    s[i] = textFields[i].getText();
                try
                {
                    Book b = new Book(s);
                    if (originalBookModel.isBook(b))
                        throw new ExeptionThisBookExist();

                    JOptionPane.showMessageDialog(null, "data added successfully");
                    originalBookModel.addBook(b);
                    setVisible(false);
                    dispose();
                }
                catch (NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog(null, "incorrect data format, price and count must be positive");
                }
                catch (ExeptionDateNotExist exception)
                {
                    JOptionPane.showMessageDialog(null, exception);
                }
                catch (ExeptionDate exception)
                {
                    JOptionPane.showMessageDialog(null, exception);
                }
                catch (ExeptionThisBookExist exception) {
                    JOptionPane.showMessageDialog(null, exception);;
                }
            }
        });
    }
}
