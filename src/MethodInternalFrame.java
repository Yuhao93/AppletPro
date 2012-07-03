//A JInternalFrame which represents a method. The user will work through these internal frames 
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MethodInternalFrame extends JInternalFrame implements Serializable, ActionListener, KeyListener
{
    private JTextArea script;
    private JButton applychange;
    private JTextField returntype;
    private JTextField changename;
    private JTextField paramtype;
    private JTextField paramname;
    private JButton applyparam;
    private JList paramlist;
    private String[] params;
    public AppletMethod am;
    public MethodInternalFrame(AppletMethod appmethod)
    {
        super(appmethod.name,true,true,true,true);
        am = appmethod;
        setVisible(true);
        script = new JTextArea(8,15);
        script.addKeyListener(this);
        JScrollPane scroll = new JScrollPane(script);
        applychange = new JButton("Apply Changes");
        applychange.addActionListener(this);
        returntype = new JTextField("Return Type: Default is void");
        changename = new JTextField("Change Name");
        changename.addActionListener(this);
        paramtype = new JTextField("Parameter Type");
        paramname = new JTextField("Parameter Name");
        applyparam = new JButton("Add Parameter");
        applyparam.addActionListener(this);
        paramlist = new JList();
        paramlist.setLayoutOrientation(JList.VERTICAL);
        paramlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        params = new String[0];
        JScrollPane scrollparam = new JScrollPane(paramlist);
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(paramtype, BorderLayout.NORTH);
        p1.add(paramname, BorderLayout.CENTER);
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(p1,BorderLayout.NORTH);
        p2.add(applyparam, BorderLayout.CENTER);
        p2.add(scrollparam, BorderLayout.SOUTH);
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(returntype,BorderLayout.NORTH);
        p3.add(changename,BorderLayout.CENTER);
        p3.add(applychange,BorderLayout.EAST);
        add(p3,BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        pack();
    }
    public void keyReleased(KeyEvent e)
    {
            am.code = script.getText();
    }
    public void keyPressed(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource().equals(applychange))
        {
            am.changeProperties(changename.getText());
            am.returntype = returntype.getText();
        }
        if (ae.getSource().equals(applyparam))
        {
            boolean paramexist = false;
           if ((paramtype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("int"))||
                    (paramtype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("double"))||
                    (paramtype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("String"))||
                    (paramtype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("boolean"))||
                    (paramtype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("Color"))||
                    (paramtype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("Font"))||
                    (paramtype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("Image"))||
                    (paramtype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("AudioClip")))
            {
                paramexist = true;
            }
            for (int i = 0; i < am.appframe.classnames.length; i ++)
            {
                if (am.appframe.classnames[i].equals(paramtype.getText().replace("[", "").replace("]", "")))
                    paramexist = true;
            }
            if (paramexist)
            {
                String[] temp = new String[params.length];
                temp = params;
                params = new String[params.length+1];
                System.arraycopy(temp, 0, params, 0, temp.length);
                params[params.length-1] = paramtype.getText()+" "+paramname.getText();
                DefaultListModel d = new DefaultListModel();
                for (int i=0; i < params.length;i++)
                    d.addElement(params[i]);
                paramlist.setModel(d);
                am.params = params;
            }
        }
    }
}
