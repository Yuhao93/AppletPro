//The toolbar, contains code for all of the buttons found in the toolbar
import javax.swing.*;
import java.awt.event.*;

public class AppletFrameToolbar extends JToolBar implements ActionListener
{
    private  JButton newobj;
    private  JButton newres;
    private  JButton newaud;
    private  JButton newmethod;
    private  JButton build;
    private  JButton properties;
    private  AppletFrame appframe;
    
    public AppletFrameToolbar(AppletFrame af)
    {
        appframe = af;
        setFloatable(false);
        setVisible(true);
        newobj = new JButton(appframe.classico);
        newobj.setToolTipText("New Class");
        newres = new JButton(appframe.resico);
        newres.setToolTipText("New Graphic");
        newaud = new JButton(appframe.musicico);
        newaud.setToolTipText("New Audio");
        newmethod = new JButton(appframe.scriptico);
        newmethod.setToolTipText("New Method");
        build = new JButton(appframe.buildico);
        build.setToolTipText("Build Project");
        properties = new JButton(appframe.propico);
        properties.setToolTipText("Main Applet Class");
        newobj.addActionListener(this);
        newres.addActionListener(this);
        newaud.addActionListener(this);
        newmethod.addActionListener(this);
        build.addActionListener(this);
        properties.addActionListener(this);
        add(newobj);
        add(newres);
        add(newaud);
        add(newmethod);
        add(build);
        add(properties);
    }
    public void actionPerformed(ActionEvent e)
    {
        //does similar actions as the menu; however, the main Applet class can be accessed from here
        if (e.getSource().equals(newobj))
        {
            appframe.ncf.setVisible(true);
        }
        if (e.getSource().equals(newres))
        {
            appframe.ngf.setVisible(true);
        }
        if (e.getSource().equals(newaud))
        {
            appframe.nsf.setVisible(true);
        }
        if (e.getSource().equals(newmethod))
        {
            appframe.nmf.setVisible(true);
        }
        if (e.getSource().equals(build))
        {
            LoadBuildFrame lbf = new LoadBuildFrame(appframe.appletproperties,appframe.classes,appframe.graphics,appframe.audio,appframe.methods,appframe,Integer.parseInt(appframe.properties.sizeX.getText()),Integer.parseInt(appframe.properties.sizeY.getText()),Integer.parseInt(appframe.properties.colorR.getText()),Integer.parseInt(appframe.properties.colorG.getText()),Integer.parseInt(appframe.properties.colorB.getText()));
        }
        if (e.getSource().equals(properties))
        {
            //opens the main Applet class if not already open
            appframe.appletpropinternalframe.setVisible(true);
            if (!appframe.appletpropinternalframe.isDisplayable())
            {
                appframe.MainScreen.add(appframe.appletpropinternalframe);
            }
        }
    }
}