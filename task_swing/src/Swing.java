import javafx.beans.property.adapter.JavaBeanBooleanProperty;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Swing extends JFrame {
    private void addButListener1(JFrame frame, JButton but)
    {
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ChangeWindow changeWindow = new AddWindow(frame, "Add new book");
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
        BookModel m = new BookModel();
        JTable table = new JTable(m);

        //JScrollPane
        JScrollPane jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);

        //Panel button
        JPanel butPan = new JPanel();
        JPanel panel1 = new JPanel();

        panel1.setLayout(new GridLayout(0,1, 2, 10));
        butPan.setBackground(Color.GRAY);
        add(butPan, BorderLayout.EAST);

        //JButtons
        JButton butAdd = new JButton("Add");
        panel1.add(butAdd);
        addButListener1(this,butAdd);

        JButton butDel = new JButton("Del");
        panel1.add(butDel);
        butPan.add(panel1, BorderLayout.NORTH);

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
