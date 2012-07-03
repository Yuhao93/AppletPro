//Frame which recieves inital information required to create a new Project
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NewFileFrame extends JFrame implements ActionListener, MouseListener
{
    private JLabel title;
    private JTextField name;
    private JButton create;
    private AppletFrame appframe;
    public NewFileFrame(AppletFrame af)
    {
        appframe = af;
        setResizable(false);
        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        title = new JLabel("New Applet");
        add(title, BorderLayout.NORTH);
        name = new JTextField("Name");
        add(name, BorderLayout.CENTER);
        create = new JButton("Finish");
        add(create,BorderLayout.SOUTH);
        name.addMouseListener(this);
        create.addActionListener(this);
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
        if (e.getSource().equals(name))
        {
            name.setText("");
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(create))
        {
            setVisible(false);
            AppletFrame af = new AppletFrame(name.getText());
            af.validate();
            appframe.dispose();
        }
    }
}
