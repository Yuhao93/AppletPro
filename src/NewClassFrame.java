//Frame which recieves inital information required to create a new Class
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
public class NewClassFrame extends JFrame implements MouseListener, Serializable
{
    private JTextField textfield;
    private JButton button;
    private AppletFrame appframe;
    public NewClassFrame(AppletFrame af)
    {
        JLabel title = new JLabel("New Class");
        textfield = new JTextField("Class Name");
        button = new JButton("Create New Class");
        appframe = af;
        textfield.addMouseListener(this);
        button.addMouseListener(this);
        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(textfield, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        pack();
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e)
    {
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseClicked(MouseEvent e)
    {
        if (e.getSource().equals(textfield))
        {
            textfield.setText("");
        }
        if (e.getSource().equals(button))
        {
            setVisible(false);
            appframe.addNewClass(textfield.getText());
            textfield.setText("Class Name");
        }
    }
}
