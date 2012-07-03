//The first frame the user encounters. It will work in the same way NewFileFrame works. **Opening function is not yet implemented. It will be updated in future versions**
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StartWindow extends JFrame implements ActionListener
{
    JTextField new_name;
    JButton create;
    JButton open;
    JFileChooser fc;
    public StartWindow()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new_name = new JTextField("File Name");
        create = new JButton("Create New Applet");
        open = new JButton("Open Existing Applet");
        fc = new JFileChooser(".");
        add(new_name, BorderLayout.NORTH);
        add(create, BorderLayout.CENTER);
        add(open, BorderLayout.SOUTH);
        create.addActionListener(this);
        open.addActionListener(this);
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource().equals(create))
        {
            AppletFrame af = new AppletFrame(new_name.getText().replace(" ", "_"));
            af.validate();
            dispose();
        }
        if (ae.getSource().equals(open))
        {
            int i = fc.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION)
            {
            }
        }
    }
}