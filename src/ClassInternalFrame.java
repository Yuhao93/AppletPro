//A JInternalFrame which represents a class. The user will work through these internal frames 
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class ClassInternalFrame extends JInternalFrame implements ListSelectionListener, ActionListener, KeyListener, Serializable
{
    private  JList eventlist;
    private  JTextArea codelist;
    public JTextField name;
    public JButton applychanges;
    private JTextField vartype;
    private JTextField varname;
    public JList varlist;
    private JButton addvar;
    public String[] codes;
    public String[] instances;
    public AppletClass ac;
    private int currentind;
    public ClassInternalFrame(AppletClass appclass)
    {
        super(appclass.classname,true,true,true,true);
        setVisible(true);
        ac = appclass;
        JSplitPane window = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        window.setEnabled(false);
        name = new JTextField("Change Class Name");
        applychanges = new JButton("Apply Chnages");
        applychanges.addActionListener(this);
        DefaultListModel events = new DefaultListModel();
        events.addElement("run");
        events.addElement("mouseExited");
        events.addElement("mouseEntered");
        events.addElement("mouseReleased");
        events.addElement("mousePressed");
        events.addElement("mouseClicked");
        events.addElement("mouseMoved");
        events.addElement("mouseDragged");
        events.addElement("keyReleased");
        events.addElement("keyPressed");
        events.addElement("keyTyped");
        events.addElement("init");
        events.addElement("paint");
        codes = appclass.codes;
        eventlist = new JList(events);
        eventlist.setLayoutOrientation(JList.VERTICAL);
        eventlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventlist.addListSelectionListener(this);
        JScrollPane scrollevent = new JScrollPane(eventlist);
        codelist = new JTextArea(11,35);
        codelist.setText("");
        codelist.addKeyListener(this);
        JScrollPane scrollcode = new JScrollPane(codelist);
        window.setLeftComponent(scrollevent);
        window.setRightComponent(scrollcode);
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(name, BorderLayout.CENTER);
        p1.add(applychanges, BorderLayout.EAST);
        vartype = new JTextField("Class Type");
        varname = new JTextField("Instance Name");
        addvar = new JButton("Add Instance");
        addvar.addActionListener(this);
        varlist = new JList();
        varlist.setLayoutOrientation(JList.VERTICAL);
        varlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        instances = new String[0];
        JScrollPane scrollinstance = new JScrollPane(varlist);
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(vartype,BorderLayout.CENTER);
        p3.add(varname, BorderLayout.SOUTH);
        p2.add(p3,BorderLayout.NORTH);
        p2.add(addvar, BorderLayout.CENTER);
        p2.add(scrollinstance,BorderLayout.SOUTH);
        add(p1, BorderLayout.NORTH);
        add(window, BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        pack();
    }
    public void keyReleased(KeyEvent e)
    {
        codes[currentind] = codelist.getText();
        ac.codes = codes;
    }
    public void keyPressed(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting())
        {
            if (eventlist.getSelectedIndex() > -1)
            {
                if (!(codelist.getText().equals(null)))
                    codes[currentind] = codelist.getText();
                else
                    codes[currentind] = "";
                currentind = eventlist.getSelectedIndex();
                codelist.setText(codes[eventlist.getSelectedIndex()]);
            }
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(applychanges))
        {
            setTitle(name.getText());
            ac.changeProperties(name.getText());
        }
        if (e.getSource().equals(addvar))
        {
            boolean varexist = false;
            if ((vartype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("int"))||
                    (vartype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("double"))||
                    (vartype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("String"))||
                    (vartype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("boolean"))||
                    (vartype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("Color"))||
                    (vartype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("Font"))||
                    (vartype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("Image"))||
                    (vartype.getText().replaceAll(" ", "").replace("[","").replace("]", "").equals("AudioClip")))
            {
                varexist = true;
            }
            for (int i = 0; i < ac.appframe.classnames.length; i ++)
            {
                if (ac.appframe.classnames[i].equals(vartype.getText().replace("[", "").replace("]", "")))
                    varexist = true;
            }
            if (varexist)
            {
                String[] temp = new String[instances.length];
                temp = instances;
                instances = new String[instances.length+1];
                System.arraycopy(temp, 0, instances, 0, temp.length);
                instances[instances.length-1] = vartype.getText()+","+varname.getText();
                DefaultListModel d = new DefaultListModel();
                for (int i=0; i < instances.length;i++)
                    d.addElement(instances[i]);
                varlist.setModel(d);
                ac.instances = instances;
            }
        }
    }
}
