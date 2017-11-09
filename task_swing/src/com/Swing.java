package com;

import com.Data.BookModel;
import com.Windows.AddWindow;
import com.Windows.ChangeWindow;
import com.Windows.ChangeWindowHeir;
import com.Windows.DeleteWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Swing extends JFrame {
    private BookModel bookModel = new BookModel(true);
    JTable table;

    private void addButListener(JFrame frame, JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new AddWindow(frame,  bookModel,"Add new book");
            }
        });
    }
    private boolean isMarksRow()
    {
        return table.getSelectedRows().length > 0;
    }
    private void changeButListener(JFrame frame, JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if (isMarksRow())
                {
                    new ChangeWindowHeir(frame, bookModel, table);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "select the row to be changed");
                }
            }
        });
    }
    private void deleteButListener(JFrame frame, JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if (isMarksRow())
                {
                    new DeleteWindow(frame, bookModel, table);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "select the rows to be deleted");
                }
            }
        });
    }
    private void saveButListener(JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                bookModel.writeData();
            }
        });
    }
    public Swing() {
        //window
        super("com.Data.Book counting");
        setSize(750, 350);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        ChangeWindow.centerFrame(this);
        //data
        BookModel.readData(bookModel);
        table = new JTable(bookModel);

        //JScrollPane
        JScrollPane jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);

        //panel, button's panel
        JPanel butPan = new JPanel();
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(0,1, 2, 10));
        add(butPan, BorderLayout.EAST);
        butPan.add(panel, BorderLayout.NORTH);

        //JButtons
        //add
        JButton butAdd = new JButton("Add");
        panel.add(butAdd);
        addButListener(this,butAdd);
        //change
        JButton butChange = new JButton("Change");
        panel.add(butChange);
        changeButListener(this, butChange);
        //delete
        JButton butDel = new JButton("Delete");
        panel.add(butDel);
        deleteButListener(this, butDel);

        JButton butSave = new JButton("Save");
        panel.add(butSave);
        saveButListener(butSave);

        setVisible(true);
    }
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing();
            }
        });
    }
}
