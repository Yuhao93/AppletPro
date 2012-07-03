//Frame which recieves inital information required to create a new Graphic
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
public class NewGraphicFrame extends JFrame implements MouseListener, Serializable
{
    JLabel name;
    private transient Image img;
    private JLabel thumbnail;
    private JTextField text;
    private JButton button;
    private JButton filebutton;
    private JFileChooser choose;
    private AppletFrame appframe;
    private File copy;
    private String copyPath;
    public NewGraphicFrame(AppletFrame af)
    {
        setLayout(new BorderLayout());
        name = new JLabel("New Graphic");
        text = new JTextField("Graphic Name");
        button = new JButton("Create New Graphic");
        filebutton = new JButton("Load Graphic");
        thumbnail = new JLabel();
        text.addMouseListener(this);
        button.addMouseListener(this);
        filebutton.addMouseListener(this);
        choose = new JFileChooser(".");
        appframe = af;
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        this.add(name, BorderLayout.NORTH);
        p1.add(text, BorderLayout.NORTH);
        p2.add(filebutton, BorderLayout.CENTER);
        p2.add(thumbnail, BorderLayout.SOUTH);
        p1.add(p2, BorderLayout.CENTER);
        add(p1,BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        pack();
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
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
        if (e.getSource().equals(button)&&(!(img==null)))
        {
            setVisible(false);
            appframe.addNewGraphic(text.getText(), img, copy);
            img = null;
            text.setText("Graphic Name");
        }
        if (e.getSource().equals(text))
        {
            text.setText(null);
        }
        if (e.getSource().equals(filebutton))
        {
            choose.setFileFilter(new ExtensionFileFilter("png", "PNG Files"));
            int n = choose.showDialog(this, "Load");
            if (n == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    copy = choose.getSelectedFile();
                    copyPath = "C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\Output\\res\\img_"+text.getText()+".png";
                    img = ImageIO.read(choose.getSelectedFile());
                    thumbnail.setIcon(new ImageIcon(img.getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
                    pack();
                }
                catch (Exception ex)
                {
                }
            }
        }
    }
}
