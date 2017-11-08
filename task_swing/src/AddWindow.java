import javax.swing.*;
import java.awt.*;

public class AddWindow extends ChangeWindow {
    JPanel textPan;
    JPanel grPan;
    JTextField textFieldsf[];
    JLabel labels[];
    AddWindow(JFrame frame, String name)
    {
        super(frame, name);
        textPan = new JPanel();
        add(textPan, BorderLayout.CENTER);
        grPan = new JPanel();
        textPan.add(grPan);
        BookModel bookModel = new BookModel();
        textFieldsf = new JTextField[bookModel.getColumnCount()];
        labels = new JLabel[bookModel.getColumnCount()];
        grPan.setLayout(new GridLayout(2,bookModel.getColumnCount(), 2, 10));
        for (int i = 0; i < bookModel.getColumnCount(); i++)
        {
            labels[i] = new JLabel(bookModel.getColumnName(i));
            grPan.add(labels[i]);
        }
        for (int i = 0; i < bookModel.getColumnCount(); i++)
        {
            textFieldsf[i] = new JTextField(bookModel.getValueAt(0, i).toString());
            grPan.add(textFieldsf[i]);
        }

        setVisible(true);
    }
}
