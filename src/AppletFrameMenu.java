//The menu, contains code for all of the items found in the menu. **In this version, saving and opening of files is not supported but will be updated in future versions**
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class AppletFrameMenu extends JMenuBar implements ActionListener
{
    private JMenu file;
    private  JMenu edit;
    private  JMenu run;
    private JMenu help;
    private  JMenuItem newfile;
    private  JMenuItem open;
    private  JMenuItem save;
    private  JMenuItem addres;
    private  JMenuItem addaud;
    private  JMenuItem addobj;
    private JMenuItem mainClassEdit;
    private  JMenuItem addscript;
    private JMenuItem setProp;
    private  JMenuItem build;
    private JMenuItem documentation;
    private JFileChooser fc;
    private  AppletFrame appframe;
    public AppletFrameMenu(AppletFrame af)
    {
        appframe = af;
        file = new JMenu("File");
        edit = new JMenu("Edit");
        run = new JMenu("Run");
        help = new JMenu("Help");
        newfile = new JMenuItem("New File", appframe.newico);
        open = new JMenuItem("Open", appframe.openico);
        save = new JMenuItem("Save", appframe.saveico);
        addres = new JMenuItem("Add Graphic", appframe.resico);
        addaud = new JMenuItem("Add Audio", appframe.musicico);
        addobj = new JMenuItem("Add Class", appframe.classico);
        mainClassEdit = new JMenuItem("Main Class", appframe.classico);
        addscript = new JMenuItem("Add Method", appframe.scriptico);
        setProp = new JMenuItem("Change Build Properties", appframe.tutorialico);
        build = new JMenuItem("Build Applet", appframe.buildico);
        documentation = new JMenuItem("Documentation", appframe.infoico);
        file.add(newfile);
        file.add(open);
        file.add(save);
        edit.add(addres);
        edit.add(addaud);
        edit.add(addobj);
        edit.add(mainClassEdit);
        edit.add(addscript);
        edit.add(setProp);
        run.add(build);
        help.add(documentation);
        newfile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        addres.addActionListener(this);
        addaud.addActionListener(this);
        addobj.addActionListener(this);
        mainClassEdit.addActionListener(this);
        addscript.addActionListener(this);
        setProp.addActionListener(this);
        build.addActionListener(this);
        run.addActionListener(this);
        documentation.addActionListener(this);
        add(file);
        add(edit);
        add(run);
        add(help);
        fc = new JFileChooser(".");
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(newfile))
        {
            //creates a new instance of the program.
            appframe.nff.setVisible(true);
            appframe.nff.requestFocus();
        }
        if (e.getSource().equals(open))
        {
            int n = fc.showOpenDialog(this);
            if (n == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()));
                    System.out.println("?");
                    int graphiclength = Integer.parseInt(br.readLine());
                    System.out.println("work?");
                    int soundlength = Integer.parseInt(br.readLine());
                    System.out.println("still work?");
                    ObjectInputStream os;
                    os  = new ObjectInputStream(new FileInputStream(br.readLine()));
                    AppletFrame af = (AppletFrame)os.readObject();
                    af.setVisible(true);
                    for (int i=0; i<graphiclength;i++)
                    {
                        os  = new ObjectInputStream(new FileInputStream(br.readLine()));
                        af.graphics[i].img = (Image)os.readObject();
                        af.graphicinternalframes[i].ag.img = (Image)os.readObject();
                    }
                    for (int i=0; i<soundlength;i++)
                    {
                        os  = new ObjectInputStream(new FileInputStream(br.readLine()));
                        af.audio[i].sound = (AudioClip)os.readObject();
                        af.audiointernalframes[i].appsound.sound = (AudioClip)os.readObject();
                    }
                }
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                    System.out.println(ex.getCause());
                }
            }
        }
        if (e.getSource().equals(save))
        {
            
            int n = fc.showSaveDialog(this);
            if (n == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    FileWriter fw = new FileWriter(fc.getCurrentDirectory().getAbsolutePath()+"\\"+fc.getSelectedFile().getName()+".appletprofile", true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(appframe.graphics.length);
                    pw.println(appframe.audio.length);
                    saveObj(appframe, "AppletFrame", pw);
                    for (int i = 0; i< appframe.graphics.length; i ++)
                    {
                        saveRes(appframe.graphics[i].savecopy, String.valueOf(i),"png",pw);
                    }
                    for (int i = 0; i< appframe.audio.length; i ++)
                    {
                        saveRes(appframe.audio[i].savecopy, String.valueOf(i),"au", pw);
                    }
                    pw.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            //end ignoring
        }
        //opens the designated window
        if (e.getSource().equals(addres))
        {
            appframe.ngf.setVisible(true);
        }
        if (e.getSource().equals(addaud))
        {
            appframe.nsf.setVisible(true);
        }
        if (e.getSource().equals(addobj))
        {
            appframe.ncf.setVisible(true);
        }
        if (e.getSource().equals(mainClassEdit))
        {
            appframe.appletpropinternalframe.setVisible(true);
            if (!appframe.appletpropinternalframe.isDisplayable())
            {
                appframe.MainScreen.add(appframe.appletpropinternalframe);
            }
        }
        if (e.getSource().equals(addscript))
        {
            appframe.nmf.setVisible(true);
        }
        if (e.getSource().equals(setProp))
        {
            appframe.properties.setVisible(true);
        }
        //compiles source code by calling loadbuildframe
        if (e.getSource().equals(build))
        {
            LoadBuildFrame lbf = new LoadBuildFrame(appframe.appletproperties,appframe.classes,appframe.graphics,appframe.audio,appframe.methods,appframe,Integer.parseInt(appframe.properties.sizeX.getText()),Integer.parseInt(appframe.properties.sizeY.getText()),Integer.parseInt(appframe.properties.colorR.getText()),Integer.parseInt(appframe.properties.colorG.getText()),Integer.parseInt(appframe.properties.colorB.getText()));
        }
        if (e.getSource().equals(documentation))
        {
            DocumentationWindow dw = new DocumentationWindow();
        }
    }
    //ignore these methods
    public void saveObj(Object obj, String instancename, PrintWriter pw)
    {
        try
        {
            File f1 = new File("C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\SaveDat\\placement.txt");
            if (!f1.exists())
            {
                f1.mkdirs();
                f1.delete();
            }
            FileOutputStream f_out = new FileOutputStream("C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\SaveDat\\"+instancename+".dat");
            ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
            obj_out.writeObject(obj);
            obj_out.flush();
            obj_out.close();
            pw.println("C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\SaveDat\\"+instancename+".dat");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void saveRes(File f, String filename, String type, PrintWriter pw)
    {
        try
        {
            File f2 = new File("C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\SaveDat\\res\\"+filename+"."+type);
            File f1 = new File("C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\SaveDat\\res\\placement.txt");
            if (!f1.exists())
            {
                f1.mkdirs();
                f1.delete();
            }
            FileInputStream fis = new FileInputStream(f);
            FileOutputStream fos = new FileOutputStream(f2);
            byte[] b = new byte[(int)f.length()];
            fis.read(b);
            fos.write(b);
            fis.close();
            fos.close();
            pw.println("C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\SaveDat\\res\\"+filename+"."+type);
        }
        catch (Exception e)
        {
        }
    }
}