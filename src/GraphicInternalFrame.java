//A JInternalFrame which represents a Graphic. The user will work through these internal frames 
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class GraphicInternalFrame extends JInternalFrame implements ActionListener, Serializable
{
    private JLabel thumbnail;
    private JButton changeimg;
    private JButton setchanges;
    private JTextField setname;
    private JTextField setdimension;
    private JFileChooser choose;
    public AppletGraphic ag;
    public GraphicInternalFrame(AppletGraphic appg)
    {
        super(appg.name,true,true,true,true);
        ag = appg;
        setVisible(true);
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        JSplitPane pane = new JSplitPane();
        pane.setEnabled(false);
        setname = new JTextField("Change Name");
        setdimension = new JTextField("Change Dimension (Width, Height)");
        setchanges = new JButton("Apply Changes");
        changeimg = new JButton("Change Image");
        changeimg.addActionListener(this);
        setchanges.addActionListener(this);
        choose = new JFileChooser();
        if ((appg.img.getWidth(this)> 200) || (appg.img.getHeight(this) > 175))
            thumbnail = new JLabel(new ImageIcon(appg.img.getScaledInstance(200, 175, Image.SCALE_SMOOTH)));
        else
            thumbnail = new JLabel(new ImageIcon(appg.img));
        thumbnail.setVerticalTextPosition(JLabel.BOTTOM);
        thumbnail.setHorizontalTextPosition(JLabel.CENTER);
        thumbnail.setText("Width:"+String.valueOf(ag.img.getWidth(this))+"px, Height:"+String.valueOf(ag.img.getHeight(this))+"px");
        p2.add(changeimg, BorderLayout.WEST);
        p2.add(setchanges, BorderLayout.EAST);
        p3.add(setdimension, BorderLayout.NORTH);
        p1.add(setname, BorderLayout.NORTH);
        p1.add(p3, BorderLayout.CENTER);
        p1.add(p2, BorderLayout.SOUTH);
        pane.setLeftComponent(p1);
        pane.setRightComponent(thumbnail);
        add(pane);
        pack();
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(changeimg))
        {
            choose.setFileFilter(new ExtensionFileFilter("png", "Image File"));
            int i = choose.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    ag.img = ImageIO.read(choose.getSelectedFile());
                    if ((ag.img.getWidth(this)> 200) || (ag.img.getHeight(this) > 175))
                        thumbnail.setIcon(new ImageIcon(ag.img.getScaledInstance(200, 175, Image.SCALE_SMOOTH)));
                    else
                        thumbnail.setIcon(new ImageIcon(ag.img));
                    thumbnail.setVerticalTextPosition(JLabel.BOTTOM);
                    thumbnail.setHorizontalTextPosition(JLabel.CENTER);
                    thumbnail.setText("Width:"+String.valueOf(ag.img.getWidth(this))+"px, Height:"+String.valueOf(ag.img.getHeight(this))+"px");
                    pack();
                }
                catch (Exception ex)
                {
                }
            }
        }
        if (e.getSource().equals(setchanges))
        {
            String newtitle = setname.getText();
            setTitle(newtitle);
            String formatdimension = setdimension.getText().replaceAll(" ", "");
            int neww = ag.width;
            int newh = ag.height;
            try
            {
                neww = Integer.parseInt(formatdimension.substring(0,formatdimension.indexOf(',')));
                newh = Integer.parseInt(formatdimension.substring(formatdimension.indexOf(',')+1,formatdimension.length()));
            }
            catch (Exception ex)
            {
            }
            ag.img = ag.img.getScaledInstance(neww, newh, Image.SCALE_SMOOTH);
            if ((ag.img.getWidth(this)> 200) || (ag.img.getHeight(this) > 175))
                thumbnail.setIcon(new ImageIcon(ag.img.getScaledInstance(200, 175, Image.SCALE_SMOOTH)));
            else
                thumbnail.setIcon(new ImageIcon(ag.img));
            thumbnail.setVerticalTextPosition(JLabel.BOTTOM);
            thumbnail.setHorizontalTextPosition(JLabel.CENTER);
            thumbnail.setText("Width:"+String.valueOf(ag.img.getWidth(this))+"px, Height:"+String.valueOf(ag.img.getHeight(this))+"px");
            ag.changeProperties(newh, newh, newtitle);
            pack();
            
        }
    }
}
