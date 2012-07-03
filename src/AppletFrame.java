//The main frame, holds the menu, the toolbar, the side tray, and all of the internal frames. Regulates all changes made to the internal frames.
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AppletFrame extends JFrame implements ActionListener, MouseListener
{
    //screen where all JInternalFrames are added
    public JDesktopPane MainScreen;
    //list which displays all the objects of the selected type(clarified later)
    private JList nameslist;
    //array of classes, the index of the classes matches the index of the internalframes.
    public AppletClass[] classes;
    public ClassInternalFrame[] classinternalframes;
    public AppletGraphic[] graphics;
    public GraphicInternalFrame[] graphicinternalframes;
    public AppletSound[] audio;
    public SoundInternalFrame[] audiointernalframes;
    public AppletMethod[] methods;
    public MethodInternalFrame[] methodinternalframes;
    //the "create a new component" frames
    public NewClassFrame ncf;
    public NewGraphicFrame ngf;
    public NewFileFrame nff;
    public NewSoundFrame nsf;
    public NewMethodFrame nmf;
    //the special appletclass that acts as the main Applet class.
    public AppletClass appletproperties;
    public ClassInternalFrame appletpropinternalframe;
    //arrays that keep track of specific names for the components. Index matches those of the other arrays
    public String[] classnames;
    public String[] graphicnames;
    public String[] audionames;
    public String[] methodnames;
    //a list to choose the current type. (classes, graphics, sounds, methods)
    //a list of the names of the current type is displayed in namesList.
    private JComboBox windowlist;
    //athestic components
    private JSplitPane windowsplit;
    private JLabel listtitle;
    public ImageIcon buildico;
    public ImageIcon classico;
    public ImageIcon helpico;
    public ImageIcon importico;
    public ImageIcon infoico;
    public ImageIcon musicico;
    public ImageIcon newico;
    public ImageIcon openico;
    public ImageIcon resico;
    public ImageIcon runico;
    public ImageIcon saveico;
    public ImageIcon scriptico;
    public ImageIcon tutorialico;
    public ImageIcon propico;
    public PropertiesWindow properties;
    private String[] tempclassname = {"<No Classes>"};
    private String[] tempgraphicname = {"<No Graphics>"};
    private String[] tempmusicname = {"<No Music>"};
    private String[] tempscriptname = {"<No Script>"};
    public AppletFrame(String name)
    {
        this.setTitle(name);
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //initiate appletproperties
        appletproperties = new AppletClass("AppletProperties", this);
        appletproperties.instances = new String[]{"int,fps","int,width","int,height"};
        appletpropinternalframe = new ClassInternalFrame(appletproperties);
        appletpropinternalframe.setVisible(false);
        appletpropinternalframe.name.setEnabled(false);
        appletpropinternalframe.applychanges.setEnabled(false);
        appletpropinternalframe.instances = new String[]{"int,fps","int,width","int,height"};
        DefaultListModel d = new DefaultListModel();
        for (int i=0;i<appletpropinternalframe.instances.length;i++)
            d.addElement(appletpropinternalframe.instances[i]);
        appletpropinternalframe.varlist.setModel(d);
        try
        {
            //load icons
            buildico = new ImageIcon(ImageIO.read(new File(getClass().getResource("build.png").getFile())));
            classico = new ImageIcon(ImageIO.read(new File(getClass().getResource("class.png").getFile())));
            helpico = new ImageIcon(ImageIO.read(new File(getClass().getResource("help.png").getFile())));
            importico = new ImageIcon(ImageIO.read(new File(getClass().getResource("import.png").getFile())));
            infoico = new ImageIcon(ImageIO.read(new File(getClass().getResource("info.png").getFile())));
            musicico = new ImageIcon(ImageIO.read(new File(getClass().getResource("music.png").getFile())));
            newico = new ImageIcon(ImageIO.read(new File(getClass().getResource("new.png").getFile())));
            openico = new ImageIcon(ImageIO.read(new File(getClass().getResource("open.png").getFile())));
            resico = new ImageIcon(ImageIO.read(new File(getClass().getResource("res.png").getFile())));
            runico = new ImageIcon(ImageIO.read(new File(getClass().getResource("run.png").getFile())));
            saveico = new ImageIcon(ImageIO.read(new File(getClass().getResource("save.png").getFile())));
            scriptico = new ImageIcon(ImageIO.read(new File(getClass().getResource("script.png").getFile())));
            tutorialico = new ImageIcon(ImageIO.read(new File(getClass().getResource("tutorial.png").getFile())));
            propico = new ImageIcon(ImageIO.read(new File(getClass().getResource("prop.png").getFile())));
        }
        catch (Exception e)
        {
        }
        //initiate a lot of other stuff and put everything in place on screen
        properties = new PropertiesWindow();
        classes = new AppletClass[0];
        classinternalframes = new ClassInternalFrame[0];
        MainScreen = new JDesktopPane();
        MainScreen.setBackground(Color.WHITE);
        MainScreen.add(appletpropinternalframe);
        ncf = new NewClassFrame(this);
        nff = new NewFileFrame(this);
        ngf = new NewGraphicFrame(this);
        nsf = new NewSoundFrame(this);
        nmf = new NewMethodFrame(this);
        AppletFrameMenu afm = new AppletFrameMenu(this);
        AppletFrameToolbar aft = new AppletFrameToolbar(this);
        setJMenuBar(afm);
        classnames = new String[0];
        graphicnames = new String[0];
        audionames = new String[0];
        methodnames = new String[0];
        graphics = new AppletGraphic[0];
        graphicinternalframes = new GraphicInternalFrame[0];
        audio = new AppletSound[0];
        audiointernalframes = new SoundInternalFrame[0];
        methods = new AppletMethod[0];
        methodinternalframes = new MethodInternalFrame[0];
        nameslist = new JList(tempclassname);
        nameslist.addMouseListener(this);
        windowsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        String[] comboboxlist = new String[4];
        comboboxlist[0] = "Classes";
        comboboxlist[1] = "Graphics";
        comboboxlist[2] = "Sound";
        comboboxlist[3] = "Script";
        windowlist = new JComboBox(comboboxlist);
        windowlist.setSelectedIndex(0);
        windowlist.addActionListener(this);
        setLayout(new BorderLayout());
        add(aft, BorderLayout.NORTH);
        windowsplit.setRightComponent(MainScreen);
        JPanel listpane = new JPanel();
        JPanel listupperpane = new JPanel();
        listupperpane.setLayout(new BorderLayout());
        listtitle = new JLabel("Class List");
        listupperpane.add(windowlist, BorderLayout.NORTH);
        listupperpane.add(listtitle,BorderLayout.CENTER);
        listpane.setLayout(new BorderLayout());
        listpane.add(listupperpane, BorderLayout.NORTH);
        JScrollPane scrollclass = new JScrollPane(nameslist);
        listpane.add(scrollclass, BorderLayout.CENTER);
        windowsplit.setLeftComponent(listpane);
        add(windowsplit, BorderLayout.CENTER);
        setVisible(true);
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e)
    {
        //opens the selected element if the element was closed
            if (nameslist.getSelectedIndex() > -1)
            {
                switch(windowlist.getSelectedIndex())
                {
                    case 0:
                        for (ClassInternalFrame cif: classinternalframes)
                        {
                            if (cif.getTitle().equals(nameslist.getModel().getElementAt(nameslist.getSelectedIndex())))
                            {
                                if (!cif.isDisplayable())
                                {
                                    cif.setVisible(true);
                                    MainScreen.add(cif);
                                }
                            }
                        }
                        break;
                    case 1:
                        for (GraphicInternalFrame gif: graphicinternalframes)
                        {
                            if (gif.getTitle().equals(nameslist.getModel().getElementAt(nameslist.getSelectedIndex())))
                            {
                                if (!gif.isDisplayable())
                                {
                                    gif.setVisible(true);
                                    MainScreen.add(gif);
                                }
                            }
                        }
                        break;
                    case 2:
                        for (SoundInternalFrame sif: audiointernalframes)
                        {
                            if (sif.getTitle().equals(nameslist.getModel().getElementAt(nameslist.getSelectedIndex())))
                            {
                                if (!sif.isDisplayable())
                                {
                                    sif.setVisible(true);
                                    MainScreen.add(sif);
                                }
                            }
                        }
                        break;
                    case 3:
                        for (MethodInternalFrame mif: methodinternalframes)
                        {
                            if (mif.getTitle().equals(nameslist.getModel().getElementAt(nameslist.getSelectedIndex())))
                            {
                                if (!mif.isDisplayable())
                                {
                                    mif.setVisible(true);
                                    MainScreen.add(mif);
                                }
                            }
                        }
                        break;
                }
            }
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(windowlist))
        {
            //changes what names list contains
            if (windowlist.getSelectedIndex() > -1)
            {
                switch(windowlist.getSelectedIndex())
                {
                    case 0:
                        listtitle.setText("Class List");
                        if (classes.length > 0)
                        nameslist.setListData(classnames);
                        else
                            nameslist.setListData(tempclassname);
                        break;
                    case 1:
                        listtitle.setText("Graphics List");
                        if (graphics.length > 0)
                        nameslist.setListData(graphicnames);
                        else
                            nameslist.setListData(tempgraphicname);
                        break;
                    case 2:
                        listtitle.setText("Audio List");
                        if (audio.length > 0)
                        nameslist.setListData(audionames);
                        else
                            nameslist.setListData(tempmusicname);
                        break;
                    case 3:
                        listtitle.setText("Methods List");
                        if (methods.length > 0)
                        nameslist.setListData(methodnames);
                        else
                            nameslist.setListData(tempscriptname);
                        break;
                }
            }
        }
    }
    //these methods are called whenever a new element is added int
    public void addNewClass(String classname)
    {
        AppletClass[] tempclass =  classes;
        classes = new AppletClass[classes.length+1];
        System.arraycopy(tempclass, 0, classes, 0, tempclass.length);
        classes[classes.length-1] = new AppletClass(classname, this);
        ClassInternalFrame[] tempframe =  classinternalframes;
        classinternalframes = new ClassInternalFrame[classinternalframes.length+1];
        System.arraycopy(tempframe, 0, classinternalframes, 0, tempframe.length);
        classinternalframes[classinternalframes.length-1] = new ClassInternalFrame(classes[classes.length-1]);
        classinternalframes[classinternalframes.length-1].setVisible(true);
        MainScreen.add(classinternalframes[classinternalframes.length-1]);
        classnames = new String[classes.length];
        for (int i = 0; i < classes.length; i ++)
        {
            classnames[i] = classes[i].classname;
        }
        nameslist.setListData(classnames);
        listtitle.setText("Class List");
        windowlist.setSelectedIndex(0);
    }
    public void addNewGraphic(String graphicname, Image img, File copy)
    {
        AppletGraphic[] tempgraphic =  graphics;
        graphics = new AppletGraphic[graphics.length+1];
        System.arraycopy(tempgraphic, 0, graphics, 0, tempgraphic.length);
        graphics[graphics.length-1] = new AppletGraphic(img, img.getWidth(this), img.getHeight(this), graphicname, this, copy);
        GraphicInternalFrame[] tempgraphicframes =  graphicinternalframes;
        graphicinternalframes = new GraphicInternalFrame[graphicinternalframes.length+1];
        System.arraycopy(tempgraphicframes, 0, graphicinternalframes, 0, tempgraphicframes.length);
        graphicinternalframes[graphicinternalframes.length-1] = new GraphicInternalFrame(graphics[graphics.length-1]);
        graphicinternalframes[graphicinternalframes.length-1].setVisible(true);
        MainScreen.add(graphicinternalframes[graphicinternalframes.length-1]);
        graphicnames = new String[graphics.length];
        for (int i = 0 ; i< graphics.length;i++)
        {
            graphicnames[i] = graphics[i].name;
        }
        nameslist.setListData(graphicnames);
        listtitle.setText("Graphics List");
        windowlist.setSelectedIndex(1);
    }
    public void addNewAudio(String audioname, AudioClip ac, String filename, File copy)
    {
        AppletSound[] tempaudio =  audio;
        audio = new AppletSound[audio.length+1];
        System.arraycopy(tempaudio, 0, audio, 0, tempaudio.length);
        audio[audio.length-1] = new AppletSound(ac, audioname, filename, this, copy);
        SoundInternalFrame[] tempaudioframes =  audiointernalframes;
        audiointernalframes = new SoundInternalFrame[audiointernalframes.length+1];
        System.arraycopy(tempaudioframes, 0, audiointernalframes, 0, tempaudioframes.length);
        audiointernalframes[audiointernalframes.length-1] = new SoundInternalFrame(audio[audio.length-1]);
        audiointernalframes[audiointernalframes.length-1].setVisible(true);
        MainScreen.add(audiointernalframes[audiointernalframes.length-1]);
        audionames = new String[audio.length];
        for (int i = 0 ; i< audio.length;i++)
        {
            audionames[i] = audio[i].name;
        }
        nameslist.setListData(audionames);
        listtitle.setText("Audio List");
        windowlist.setSelectedIndex(2);
    }
    public void addNewMethod(String methodname)
    {
        AppletMethod[] tempmethod =  methods;
        methods = new AppletMethod[methods.length+1];
        System.arraycopy(tempmethod, 0, methods, 0, tempmethod.length);
        methods[methods.length-1] = new AppletMethod(methodname, this);
        MethodInternalFrame[] tempmethodframe =  methodinternalframes;
        methodinternalframes = new MethodInternalFrame[methodinternalframes.length+1];
        System.arraycopy(tempmethodframe, 0, methodinternalframes, 0, tempmethodframe.length);
        methodinternalframes[methodinternalframes.length-1] = new MethodInternalFrame(methods[methods.length-1]);
        methodinternalframes[methodinternalframes.length-1].setVisible(true);
        MainScreen.add(methodinternalframes[methodinternalframes.length-1]);
        methodnames = new String[methods.length];
        for (int i = 0; i < methods.length; i ++)
        {
            methodnames[i] = methods[i].name;
        }
        nameslist.setListData(methodnames);
        listtitle.setText("Method List");
        windowlist.setSelectedIndex(3);
    }
    //called whenever an element has its name changed
    public void changeName(int windowindex, String oldname, String newname)
    {
        switch (windowindex)
        {
            case 0:
                for (int i = 0; i < classnames.length; i++)
                {
                    if (classnames[i].equals(oldname))
                    {
                        classnames[i] = newname;
                        nameslist.setListData(classnames);
                        listtitle.setText("Class List");
                        windowlist.setSelectedIndex(0);
                        break;
                    }
                }
                break;
            case 1:
                for (int i = 0; i < graphicnames.length; i++)
                {
                    if (graphicnames[i].equals(oldname))
                    {
                        graphicnames[i] = newname;
                        nameslist.setListData(graphicnames);
                        listtitle.setText("Graphics List");
                        windowlist.setSelectedIndex(1);
                        break;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < audionames.length; i++)
                {
                    if (audionames[i].equals(oldname))
                    {
                        audionames[i] = newname;
                        nameslist.setListData(audionames);
                        listtitle.setText("Audio List");
                        windowlist.setSelectedIndex(2);
                        break;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < methodnames.length; i++)
                {
                    if (methodnames[i].equals(oldname))
                    {
                        methodnames[i] = newname;
                        nameslist.setListData(methodnames);
                        listtitle.setText("Methods List");
                        windowlist.setSelectedIndex(3);
                        break;
                    }
                }
                break;
        }
    }
}