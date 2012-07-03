//Frame which recieves inital information required to create a new Method
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
public class NewMethodFrame extends JFrame implements ActionListener, Serializable
{
    private JTextField name;
    private JButton create;
    private AppletFrame appframe;
    public NewMethodFrame(AppletFrame af)
    {
        super("New Method");
        appframe = af;
        name = new JTextField("Method Name");
        create = new JButton("Create Method");
        create.addActionListener(this);
        setLayout(new BorderLayout());
        add(name,BorderLayout.NORTH);
        add(create, BorderLayout.CENTER);
        pack();
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource().equals(create))
        {
            setVisible(false);
            appframe.addNewMethod(name.getText());
            name.setText("Method Name");
        }
    }
}