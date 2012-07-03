//When intialized, the information from all classes, graphics, sounds, and methods are formatted into a java file and then sent to AppletWriter to write to a .java file
import java.awt.Graphics;
import java.io.*;
public class LoadBuildFrame
{
    private String[][] c;
    private String[][] cl;
    public LoadBuildFrame(AppletClass appletprop, AppletClass[] classes, AppletGraphic[] graphics, AppletSound[] sounds, AppletMethod[] methods, AppletFrame af, int width, int height, int red, int green, int blue)
    {
        AppletWriter aw;
        c = new String[16][];
        cl = new String[16][];
        c[0] = new String[14];
        c[1] = new String[6];
        c[2] = new String[10];
        c[3] = new String[3];
        c[4] = new String[3];
        c[5] = new String[3];
        c[6] = new String[3];
        c[7] = new String[5];
        c[8] = new String[5];
        c[9] = new String[4];
        c[10] = new String[4];
        c[11] = new String[3];
        c[12] = new String[6];
        c[13] = new String[17];
        c[14] = new String[6];
        c[15] = new String[1];
        cl[0] = new String[2];
        cl[1] = new String[2];
        cl[2] = new String[3];
        cl[3] = new String[3];
        cl[4] = new String[3];
        cl[5] = new String[3];
        cl[6] = new String[3];
        cl[7] = new String[3];
        cl[8] = new String[3];
        cl[9] = new String[3];
        cl[10] = new String[3];
        cl[11] = new String[3];
        cl[12] = new String[1];
        cl[13] = new String[1];
        cl[14] = new String[3];
        cl[15] = new String[2];
        String[] source = new String[0];
        c[0][0] = "import java.applet.*;";
        c[0][1] = "import java.awt.*;";
        c[0][2] = "import java.awt.event.*;";
        c[0][3] = "import java.io.*;";
        c[0][4] = "import java.net.*;";
        c[0][5] = "import java.util.ArrayList;";
        c[0][6] = "public class "+af.getTitle()+" extends Applet implements MouseListener, MouseMotionListener, KeyListener, Runnable";
        c[0][7] = "{";
        c[0][8] = "    public int mx;";
        c[0][9] = "    public int my;";
        c[0][10] = "    public Thread thread;";
        c[0][11] = "    public Image canvas;";
        c[0][12] = "    public Graphics2D buffer;";
        c[0][13] = "    public String keyname;";
        c[1][0] = "    public void run()";
        c[1][1] = "    {";
        c[1][2] = "        while (true)";
        c[1][3] = "        {";
        c[1][4] = "            try";
        c[1][5] = "            {";
        c[2][0] = "               Thread.sleep(1000/fps);";
        c[2][1] = "               repaint();";
        c[2][2] = "            }";
        c[2][3] = "            catch (Exception e)";
        c[2][4] = "            {";
        c[2][5] = "            }";
        c[2][6] = "        }";
        c[2][7] = "    }";
        c[2][8] = "    public void mouseExited(MouseEvent e)";
        c[2][9] = "    {";
        c[3][0] = "    }";
        c[3][1] = "    public void mouseEntered(MouseEvent e)";
        c[3][2] = "    {";
        c[4][0] = "    }";
        c[4][1] = "    public void mouseReleased(MouseEvent e)";
        c[4][2] = "    {";
        c[5][0] = "    }";
        c[5][1] = "    public void mousePressed(MouseEvent e)";
        c[5][2] = "    {";
        c[6][0] = "    }";
        c[6][1] = "    public void mouseClicked(MouseEvent e)";
        c[6][2] = "    {";
        c[7][0] = "    }";
        c[7][1] = "    public void mouseMoved(MouseEvent e)";
        c[7][2] = "    {";
        c[7][3] = "        mx = e.getX();";
        c[7][4] = "        my = e.getY();";
        c[8][0] = "    }";
        c[8][1]= "    public void mouseDragged(MouseEvent e)";
        c[8][2] = "    {";
        c[8][3] = "        mx = e.getX();";
        c[8][4] = "        my = e.getY();";
        c[9][0] = "    }";
        c[9][1] = "    public void keyReleased(KeyEvent e)";
        c[9][2] = "    {";
        c[9][3] = "         keyname = \"\";";
        c[10][0] = "    }";
        c[10][1] = "    public void keyPressed(KeyEvent e)";
        c[10][2] = "    {";
        c[10][3] = "        keyname = KeyEvent.getKeyText(e.getKeyCode());";
        c[11][0] = "    }";
        c[11][1] = "    public void keyTyped(KeyEvent e)";
        c[11][2] = "    {";
        c[12][0] = "    }";
        c[12][1] = "    @Override public void init()";
        c[12][2] = "    {";
        c[12][3] = "        fps = 30;";
        c[12][4] = "        width = 800;";
        c[12][5] = "        height = 600;";
        c[13][0] = "        setSize(width,height);";
        c[13][1] = "        canvas = createImage(width,height);";
        c[13][2] = "        buffer = (Graphics2D)canvas.getGraphics();";
        c[13][3] = "        thread = new Thread(this);";
        c[13][4] = "        thread.start();";
        c[13][5] = "        repaint();";
        c[13][6] = "        addMouseListener(this);";
        c[13][7] = "        addMouseMotionListener(this);";
        c[13][8] = "        addKeyListener(this);";
        c[13][9] = "    }";
        c[13][10] = "    @Override public void paint(Graphics gr)";
        c[13][11] = "    {";
        c[13][12] = "		buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);";
        c[13][13] = "       buffer.setColor(new Color(255,255,255));";
        c[13][14] = "       buffer.fillRect(0,0,width,height);";
        c[13][15] = "		Graphics2D g = (Graphics2D)gr;";	
        c[13][16] = "		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);";
        c[14][0] = "        g.drawImage(canvas, 0, 0, this);";
        c[14][1] = "    }";
        c[14][2] = "    @Override public void update(Graphics g)";
        c[14][3] = "    {";
        c[14][4] = "        paint(g);";
        c[14][5] = "    }";
        c[15][0] = "}";
        cl[0][0] = "class ";
        cl[0][1] = "{";
        cl[1][0] = "    public void run()";
        cl[1][1] = "    {";
        cl[2][0] = "    }";
        cl[2][1] = "    public void mouseExited()";
        cl[2][2] = "    {";
        cl[3][0] = "    }";
        cl[3][1] = "    public void mouseEntered()";
        cl[3][2] = "    {";
        cl[4][0] = "    }";
        cl[4][1] = "    public void mouseReleased()";
        cl[4][2] = "    {";
        cl[5][0] = "    }";
        cl[5][1] = "    public void mousePressed()";
        cl[5][2] = "    {";
        cl[6][0] = "    }";
        cl[6][1] = "    public void mouseClicked()";
        cl[6][2] = "    {";
        cl[7][0] = "    }";
        cl[7][1] = "    public void mouseMoved()";
        cl[7][2] = "    {";
        cl[8][0] = "    }";
        cl[8][1] = "    public void mouseDragged()";
        cl[8][2] = "    {";
        cl[9][0] = "    }";
        cl[9][1] = "    public void keyReleased()";
        cl[9][2] = "    {";
        cl[10][0] = "    }";
        cl[10][1] = "    public void keyPressed()";
        cl[10][2] = "    {";
        cl[11][0] = "    }";
        cl[11][1] = "    public void keyTyped()";
        cl[11][2] = "    {";
        cl[12][0] = "    }";
        cl[13][0] = "    {";
        cl[14][0] = "    }";
        cl[14][1] = "    public void paint(Applet a)";
        cl[14][2] = "    {";
        cl[15][0] = "    }";
        cl[15][1] = "}";
        source = addStringArray(c[0], formatInstances(appletprop));
        for (AppletGraphic g: graphics)
        {
            source = addStringArray(source, new String[]{"public Image "+g.name+";"});
        }
        for (AppletSound s: sounds)
        {
            source = addStringArray(source, new String[]{"public AudioClip "+s.name+";"});
        }
        for (int i=0;i<13;i++)
        {
            String[] s = appletprop.codes[i].split("\n");
            for (int j=0;j<s.length;j++)
            {
                s[j] = translate(s[j]);
            }
            source = addStringArray(source, c[i+1]);
            if (i==11)
            {
                for (AppletGraphic graphic:graphics)
                {
                    saveRes(graphic.savecopy,graphic.name,"png",af);
                    source = addStringArray(source, new String[]{graphic.name+" = getImage(getCodeBase(),\"res/"+graphic.name+".png\");"});
                }
                for (AppletSound sound: sounds)
                {
                    saveRes(sound.savecopy, sound.name, "au", af);
                    source = addStringArray(source, new String[]{sound.name+" = getAudioClip(getCodeBase(),\"res/"+sound.name+".au\");"});
                }
            }
            source = addStringArray(source, s);
        }
        source = addStringArray(source, c[14]);
        for (AppletMethod a: methods)
        source = addStringArray(source, addMethod(a));
        for (int i=0;i<classes.length;i++)
        {
            source = addStringArray(source, addClass(classes[i]));
        }
        source = addStringArray(source, c[15]);
        aw = new AppletWriter(source, af.getTitle(),af, width, height, calculateHex(red,green,blue));
        
    }
    public String calculateHex(int r, int g, int b)
    {
        String s = "0123456789ABCDEF";
        String output = "";
        output+=String.valueOf(s.charAt((int)(r-(r%16))/16));
        output+=String.valueOf(s.charAt(r%16));
        output+=String.valueOf(s.charAt((int)(g-(g%16))/16));
        output+=String.valueOf(s.charAt(g%16));
        output+=String.valueOf(s.charAt((int)(b-(b%16))/16));
        output+=String.valueOf(s.charAt(b%16));
        return output;
    }
    public String[] formatInstances(AppletClass ac)
    {
        String[] s1 = new String[ac.instances.length];
        for (int i=0;i<s1.length;i++)
        {
            s1[i] = "public "+ac.instances[i].split(",")[0]+" "+ac.instances[i].split(",")[1]+";";
        }
        return s1;
    }
    public String[] addClass(AppletClass ac)
    {
        String[] s1 = formatInstances(ac);
        String[][] s = new String[13][];
        String[] resultant;
        for (int i=0;i<13;i++)
        {
            s[i] = new String[ac.codes[i].split("\n").length];
            s[i] = ac.codes[i].split("\n");
            for (int j=0;j<s[i].length;j++)
            {
                s[i][j] = translate(s[i][j]);
                if (s[i][j].contains("buffer.drawImage("))
                {
                    s[i][j] = s[i][j].replace(",this", ",a");
                }
            }
        }
        resultant = addStringArray(cl[0], s1);
        resultant[0] = resultant[0]+" "+ac.classname;
        for (int i=0;i<12;i++)
        {
            if (i == 11)
            {
                resultant = addStringArray(resultant, cl[12]);
                resultant = addStringArray(resultant, new String[]{"public "+ac.classname+"()"});
                resultant = addStringArray(resultant, cl[13]);
            }
            else
                resultant = addStringArray(resultant, cl[i+1]);
            resultant = addStringArray(resultant, s[i]);
        }
        resultant = addStringArray(resultant, cl[14]);
        resultant = addStringArray(resultant, s[12]);
        resultant = addStringArray(resultant, cl[15]);
        return resultant;
    }
    public String[] addMethod(AppletMethod am)
    {
        String[] s = new String[am.code.split("\n").length];
        s = am.code.split("\n");
        String[] s1 = new String[s.length+3];
        String s2 = "";
        for (int i=0;i<am.params.length;i++)
        {
            if (i == 0)
                s2 = am.params[i];
            else
                s2 += ","+am.params[i];
        }
        s1[0] = "public "+am.returntype+" "+am.name+"("+s2+")";
        s1[1] = "{";
        System.arraycopy(s, 0, s1, 2, s.length);
        s1[s1.length-1] = "}";
        return s1;
    }
    public String[] addStringArray(String[] s1, String[] s2)
    {
        String[] t1 = s1;
        String[] t2 = s2;
        String[] t = new String[s1.length+s2.length];
        System.arraycopy(t1, 0, t, 0, s1.length);
        System.arraycopy(t2, 0, t, t1.length, t2.length);
        return t;
    }
    public String translate(String line)
    {
        line = line.trim();
        if (line.contains("getMouseX()"))
        {
            line = line.replaceAll("getMouseX\\(\\)", "mx");
        }
        if (line.contains("getMouseY()"))
        {
            line = line.replaceAll("getMouseY\\(\\)", "my");
        }
        if (line.startsWith("setSize("))
        {
            line = line.replaceFirst(" ", "").replaceAll("setSize\\(", "setSize(");
        }
        if (line.startsWith("draw("))
        {
            String param = line.replaceAll(" ", "").replaceFirst("draw\\(", "").replace(");", "");
            line = "buffer.drawImage("+param+",this);";
        }
        if (line.startsWith("scale("))
        {
            String param = line.replaceAll(" ", "").replaceFirst("scale\\(", "").replace(");", "");
            line = "buffer.drawImage("+param+",this);";
        }
        if (line.startsWith("setColor("))
        {
            line = line.replaceFirst("setColor\\(","buffer.setColor(");
        }
        if (line.startsWith("setFont("))
        {
            line = line.replaceFirst("setFont\\(","buffer.setFont(");
        }
        if (line.startsWith("drawRect("))
        {
            line = line.replaceFirst("drawRect\\(", "buffer.drawRect(");
        }
        if(line.startsWith("drawLine("))
        {
        	line = line.replaceFirst("drawLine\\(", "buffer.drawLine(");
        }
        if(line.startsWith("drawCircle("))
        {
        	String param = line.replaceAll(" ","").replaceFirst("drawCircle\\(", "").replaceFirst("\\);", "");
        	String[] params = param.split(",");
        	String r = params[2];
        	String x = params[0]+" - "+r;
        	String y = params[1] +" - "+r;
        	line = "buffer.drawOval("+x+","+y+",2*"+r+",2*"+r+");";
        }
        if(line.startsWith("fillCircle("))
        {
        	String param = line.replaceAll(" ", "").replaceFirst("fillCircle\\(", "").replaceFirst("\\);", "");
        	String[] params = param.split(",");
        	String r = params[2];
        	String x = params[0]+" - "+r;
        	String y = params[1] +" - "+r;
        	line = "buffer.fillOval("+x+","+y+",2*"+r+",2*"+r+");";
        }
	if (line.startsWith("fillRect("))
        {
            line = line.replaceFirst("fillRect\\(", "buffer.fillRect(");
        }
	if (line.startsWith("write("))
        {
            line = line.replaceFirst("write\\(", "buffer.drawString(");
        }
        if (line.startsWith("play("))
        {
            line = line.replaceFirst("play\\(", "").replaceAll("\\);", "")+".play();";
        }
        if (line.startsWith("loop("))
        {
            line = line.replaceFirst("loop\\(", "").replaceAll("\\);", "")+".loop();";
        }
        if (line.startsWith("stop("))
        {
            line = line.replaceFirst("stop\\(", "").replaceAll("\\);", "")+".stop();";
        }
        return line;
    }
    public void saveRes(File f, String filename, String type, AppletFrame appframe)
    {
        File f1 = new File("C:/AppletPro/Project/"+appframe.getTitle()+"/Output/res/placement.txt");
        if (!f1.exists())
        {
            f1.mkdirs();
            f1.delete();
        }
        File f2 = new File("C:/AppletPro/Project/"+appframe.getTitle()+"/Output/res/"+filename+"."+type);
        try
        {
            FileInputStream fis = new FileInputStream(f);
            FileOutputStream fos = new FileOutputStream(f2);
            byte[] b = new byte[(int)f.length()];
            fis.read(b);
            fos.write(b);
            fis.close();
            fos.close();
        }
        catch (Exception e)
        {
        }
    }
}