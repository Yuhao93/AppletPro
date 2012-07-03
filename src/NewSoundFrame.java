//Frame which recieves inital information required to create a new Audio
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
public class NewSoundFrame extends JFrame implements ActionListener, Serializable
{
    private JLabel title;
    private JLabel soundTitle;
    private JTextField name;
    private JFileChooser fc;
    private JButton changesnd;
    private JButton confirm;
    private JButton playbutton;
    private AppletFrame appframe;
    private transient AudioClip ac;
    private File copy;
    private String copyPath;
    public NewSoundFrame(AppletFrame src)
    {
        setLayout(new BorderLayout());
        appframe = src;
        title = new JLabel("New Audio");
        soundTitle = new JLabel("");
        name = new JTextField("Audio Name");
        fc = new JFileChooser();
        changesnd = new JButton("Load Audio");
        playbutton = new JButton("Play Audio");
        confirm = new JButton("Create New Audio");
        changesnd.addActionListener(this);
        confirm.addActionListener(this);
        playbutton.addActionListener(this);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(soundTitle,BorderLayout.NORTH);
        p.add(playbutton, BorderLayout.CENTER);
        p.add(changesnd, BorderLayout.SOUTH);
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(title, BorderLayout.NORTH);
        p1.add(name, BorderLayout.CENTER);
        add(p1, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        add(confirm, BorderLayout.SOUTH);
        pack();
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(changesnd))
        {
            if (!(ac == null))
            {
                ac.stop();
                playbutton.setText("Play Audio");
            }
            fc.setFileFilter(new ExtensionFileFilter("au", "Sun Audio"));
            int i = fc.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    copy = fc.getSelectedFile();
                    copyPath = "C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\Output\\res\\aud_"+name.getText()+".png";
                    AudioClip au = Applet.newAudioClip(fc.getSelectedFile().toURI().toURL());
                    ac = au;
                    soundTitle.setText(fc.getSelectedFile().getName());
                    pack();
                }
                catch (Exception ex)
                {
                }
            }
        }
        if (e.getSource().equals(playbutton))
        {
            if (!(ac == null))
            {
                if (playbutton.getText().equals("Play Audio"))
                {
                    ac.play();
                    playbutton.setText("Stop Audio");
                }
                else
                if (playbutton.getText().equals("Stop Audio"))
                {
                    ac.stop();
                    playbutton.setText("Play Audio");
                }
            }
        }
        if (e.getSource().equals(confirm))
        {
            if (!(ac == null))
            {
            ac.stop();
            playbutton.setText("Play Audio");
            setVisible(false);
            appframe.addNewAudio(name.getText(), ac, soundTitle.getText(), copy);
            name.setText("Audio Name");
            }
        }
    }
}
