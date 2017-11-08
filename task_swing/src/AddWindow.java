import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindow extends ChangeWindow
{
    JPanel textPan;
    JPanel grPan;
    JTextField textFields[];
    JLabel labels[];
    BookModel bookModel;
    AddWindow(JFrame frame, BookModel originalBookModel, String name)
    {
        //form
        super(frame, originalBookModel, name);
        textPan = new JPanel();
        add(textPan, BorderLayout.CENTER);
        grPan = new JPanel();
        textPan.add(grPan);
        //bookModel and txt fields and labs
        bookModel = new BookModel();
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
            textFields[i] = new JTextField(bookModel.getValueAt(0, i).toString());
            grPan.add(textFields[i]);
        }
        //but
        okButListener1(butOk);
        setVisible(true);
    }
    private void okButListener1(JButton but)
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
                } catch (ExeptionThisBookExist exception) {
                    JOptionPane.showMessageDialog(null, exception);;
                }
            }
        });
    }
}
