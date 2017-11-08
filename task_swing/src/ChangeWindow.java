import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeWindow extends JDialog{
    JPanel butPan;
    JButton butOk;
    JButton butCancel;
    BookModel originalBookModel;
    public ChangeWindow()
    {
        super();
    }
    public ChangeWindow(JFrame frame, BookModel originalBookModel, String name)
    {
        super(frame, name, true);
        this.originalBookModel = originalBookModel;
        setSize(600, 250);
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
