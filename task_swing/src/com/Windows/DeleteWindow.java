package com.Windows;

import com.Data.BookModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWindow extends  ChangeWindow {
    public DeleteWindow(JFrame frame, BookModel originalBookModel, JTable table)
    {
        super(frame, originalBookModel, "Delete selected rows", 250, 100 );
        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        JLabel message = new JLabel("Do you want delete selected rows?");
        panel.add(message);
        butOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ar[] = table.getSelectedRows();
               originalBookModel.deleteRows(ar);
                setVisible(false);
                dispose();
            }
        });
        setVisible(true);
    }
}
