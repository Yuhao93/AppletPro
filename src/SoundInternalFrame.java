//A JInternalFrame which represents an audio. The user will work through these internal frames 
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class SoundInternalFrame extends JInternalFrame implements ActionListener, Serializable
{
    private JLabel soundname;
    private JTextField changename;
    private JButton changesound;
    private JButton applyname;
    public AppletSound appsound;
    private JFileChooser fc;
    public SoundInternalFrame(AppletSound as)
    {
        super(as.name, true, true, true, true);
        setVisible(true);
        appsound = as;
        setLayout(new BorderLayout());
        soundname = new JLabel(as.filename);
        changename = new JTextField("Change Name");
        changesound = new JButton("Load New Sound");
        applyname = new JButton("Apply Name Change");
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(changesound, BorderLayout.CENTER);
        p.add(applyname, BorderLayout.EAST);
        add(soundname, BorderLayout.NORTH);
        add(changename, BorderLayout.CENTER);
        add(p, BorderLayout.SOUTH);
        fc = new JFileChooser();
        applyname.addActionListener(this);
        changesound.addActionListener(this);
        pack();
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(changesound))
        {
            fc.setFileFilter(new ExtensionFileFilter("au", "Sun Audio"));
            int i = fc.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    appsound.sound = Applet.newAudioClip(fc.getSelectedFile().toURI().toURL());
                    appsound.filename = fc.getSelectedFile().getName();
                }
                catch (Exception ex)
                {
                }
            }
        }
        if (e.getSource().equals(applyname))
        {
            setTitle(changename.getText());
            appsound.changeProperties(changename.getText());
        }
    }
}
