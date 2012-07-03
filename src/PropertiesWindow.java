import javax.swing.*;
import java.awt.*;
public class PropertiesWindow extends JFrame
{
    private JLabel size,color;
    public JTextField sizeX,sizeY, colorR,colorG,colorB;
    public PropertiesWindow()
    {
        setLayout(new BorderLayout());
        setResizable(false);
        JSplitPane p = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel left = new JPanel();
        JPanel l1 = new JPanel();
        JLabel l = new JLabel("by");
        left.setLayout(new BorderLayout());
        l1.setLayout(new BorderLayout());
        JPanel right = new JPanel();
        JPanel r1 = new JPanel();
        right.setLayout(new BorderLayout());
        r1.setLayout(new BorderLayout());
        size = new JLabel("Applet View size");
        color = new JLabel("HTML Background Color");
        sizeX = new JTextField("800");
        sizeY = new JTextField("600");
        colorR = new JTextField("0");
        colorB = new JTextField("0");
        colorG = new JTextField("0");
        l1.add(sizeX, BorderLayout.NORTH);
        l1.add(l, BorderLayout.CENTER);
        l1.add(sizeY, BorderLayout.SOUTH);
        left.add(size, BorderLayout.NORTH);
        left.add(l1, BorderLayout.CENTER);
        r1.add(colorR, BorderLayout.NORTH);
        r1.add(colorG, BorderLayout.CENTER);
        r1.add(colorB, BorderLayout.SOUTH);
        right.add(color, BorderLayout.NORTH);
        right.add(r1, BorderLayout.CENTER);
        p.setLeftComponent(left);
        p.setRightComponent(right);
        add(p, BorderLayout.CENTER);
        pack();
    }
}
