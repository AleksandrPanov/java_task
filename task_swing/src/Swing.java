import javafx.beans.property.adapter.JavaBeanBooleanProperty;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Swing extends JFrame {
    private  BookModel bookModel;
    JTable table;
    private void addButListener(JFrame frame, JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ChangeWindow changeWindow = new AddWindow(frame,  bookModel,"Add new book");
            }
        });
    }
    private boolean isMarksRow()
    {
        return table.getSelectedRows().length > 0;
    }
    private void changeButListener(JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if (isMarksRow())
                {

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "select the row to be changed");
                }
            }
        });
    }
    private void deleteButListener(JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if (isMarksRow())
                {

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "select the rows to be deleted");
                }
            }
        });
    }
    public Swing() {
        //window
        super("Book counting");
        setSize(750, 350);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        ChangeWindow.centerFrame(this);
        //data
        bookModel = BookModel.readData("");
        table = new JTable(bookModel);

        //JScrollPane
        JScrollPane jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);

        //Panel button
        JPanel butPan = new JPanel();
        JPanel panel1 = new JPanel();

        panel1.setLayout(new GridLayout(0,1, 2, 10));
        butPan.setBackground(Color.GRAY);
        add(butPan, BorderLayout.EAST);
        butPan.add(panel1, BorderLayout.NORTH);

        //JButtons
        //add
        JButton butAdd = new JButton("Add");
        panel1.add(butAdd);
        addButListener(this,butAdd);
        //change
        JButton butChange = new JButton("Change");
        panel1.add(butChange);
        changeButListener(butChange);
        //delete
        JButton butDel = new JButton("Delete");
        panel1.add(butDel);
        deleteButListener(butDel);

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
