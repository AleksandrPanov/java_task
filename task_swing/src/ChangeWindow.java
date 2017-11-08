import javax.swing.*;
import java.awt.*;

public class ChangeWindow extends JDialog{
    JPanel butPan;
    JButton butOk;
    JButton butCancel;
    public ChangeWindow()
    {
        super();
    }
    public ChangeWindow(JFrame frame, String name)
    {
        super(frame, name, true);
        setSize(600, 250);
        centerFrame(this);

        butPan = new JPanel();
        add(butPan, BorderLayout.SOUTH);

        butOk = new JButton("Ok");
        butPan.add(butOk);

        butCancel = new JButton("Cancel");
        butPan.add(butCancel);
    }
    public static void centerFrame(Window frame) {
        frame.setLocationRelativeTo(null);
    }
}
