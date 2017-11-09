package com.Windows;

import com.Data.BookModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeWindow extends JDialog{
    protected JPanel butPan;
    protected JButton butOk;
    protected JButton butCancel;
    protected BookModel originalBookModel;
    public ChangeWindow()
    {
        super();
    }
    public ChangeWindow(JFrame frame, BookModel originalBookModel, String name)
    {
        this(frame, originalBookModel, name, 650, 250);
    }
    public ChangeWindow(JFrame frame, BookModel originalBookModel, String name, int width, int height)
    {
        super(frame, name, true);
        this.originalBookModel = originalBookModel;
        setSize(width, height);
        centerFrame(this);

        butPan = new JPanel();
        add(butPan, BorderLayout.SOUTH);

        butOk = new JButton("Ok");
        butPan.add(butOk);

        butCancel = new JButton("Cancel");
        butPan.add(butCancel);
        cancelButListener(butCancel);
    }
    public static void centerFrame(Window frame) {
        frame.setLocationRelativeTo(null);
    }
    private void cancelButListener(JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                dispose();
            }
        });
    }
}
