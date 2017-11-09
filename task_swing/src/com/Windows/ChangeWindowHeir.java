package com.Windows;

import com.Data.Book;
import com.Data.BookModel;
import com.Exception.ExeptionDate;
import com.Exception.ExeptionDateNotExist;
import com.Exception.ExeptionThisBookExist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeWindowHeir extends AddWindow {
    protected JTable table;
    public ChangeWindowHeir(JFrame frame, BookModel originalBookModel, JTable table) {

        super(frame, originalBookModel, "Change selected row", new BookModel());
        this.table = table;
        fillBookModel(table.getSelectedRow());
        fillTextInFields();
        setVisible(true);
    }

    private void fillTextInFields() {
        for (int i = 0; i < bookModel.getColumnCount(); i++)
        {
            textFields[i].setText(bookModel.getValueAt(0, i).toString());
        }
    }

    protected void fillBookModel(int row)
    {
       bookModel = new BookModel(true);
       bookModel.addBook(originalBookModel.getBook(row));
    }

    @Override
    protected void okButListener1(JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Book tmp = originalBookModel.getBook(table.getSelectedRow());
                int ar[] =  {table.getSelectedRow()};
                originalBookModel.deleteRows(ar);

                String s[] = new String[bookModel.getColumnCount()];
                for (int i = 0; i <bookModel.getColumnCount(); i++ )
                    s[i] = textFields[i].getText();
                try
                {
                    Book b = new Book(s);
                    if (originalBookModel.isBook(b))
                        throw new ExeptionThisBookExist();

                    JOptionPane.showMessageDialog(null, "data changed successfully");
                    originalBookModel.addBook(b);
                    setVisible(false);
                    dispose();
                }
                catch (NumberFormatException exception)
                {
                    originalBookModel.addBook(tmp);
                    JOptionPane.showMessageDialog(null, "incorrect data format, price and count must be positive");
                    setVisible(false);
                    dispose();
                }
                catch (ExeptionDateNotExist exception)
                {
                    originalBookModel.addBook(tmp);
                    JOptionPane.showMessageDialog(null, exception);
                    setVisible(false);
                    dispose();
                }
                catch (ExeptionDate exception)
                {
                    originalBookModel.addBook(tmp);
                    JOptionPane.showMessageDialog(null, exception);
                    setVisible(false);
                    dispose();
                }
                catch (ExeptionThisBookExist exception)
                {
                    originalBookModel.addBook(tmp);
                    JOptionPane.showMessageDialog(null, exception);;
                    setVisible(false);
                    dispose();
                }
            }
        });
    }
}
