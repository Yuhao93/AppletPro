//Once initialized, writes the .java file from arguments.
import java.io.*;
import javax.swing.*;
import javax.tools.*;
public class AppletWriter
{
    public AppletWriter(String[] obj_value, String obj_name, AppletFrame appframe, int width, int height, String color)
    {
        FileWriter fwrite;
        BufferedWriter bw;
        PrintWriter pw;
        //create the necessary directories
        File f1 = new File("C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\Output\\res\\a.txt");
        File f = new File("C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\Output\\"+obj_name+".java");
        File f2 = new File("C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\Output\\"+obj_name+".htm");
        f.mkdirs();
        f1.mkdirs();
        f.delete();
        f1.delete();
        try
        {
            //writes all of the java information onto a new file
            f.createNewFile();
            fwrite = new FileWriter(f);
            bw = new BufferedWriter(fwrite);
            pw = new PrintWriter(bw);
            for (String s: obj_value)
            {
                pw.println(s);
                if (s.replaceAll(" ","").startsWith("width="))
                    width = Integer.parseInt(s.replaceAll(" ","").replace("width=", "").replace(";", ""));
                if (s.replaceAll(" ", "").startsWith("height="))
                    height = Integer.parseInt(s.replaceAll(" ","").replace("height=", "").replace(";",""));
            }
            pw.close();
            bw.close();
            fwrite.close();
            Runtime.getRuntime().exec("javac C:\\AppletPro\\Project\\"+appframe.getTitle()+"\\Output\\"+obj_name+".java");
            f2.createNewFile();
            fwrite = new FileWriter(f2);
            bw = new BufferedWriter(fwrite);
            pw = new PrintWriter(bw);
            pw.println("<html>");
            pw.println("<body bgcolor=\"#"+color+"\">");
            pw.println("<applet code=\""+obj_name+".class\" width=\""+width+"\" height=\""+height+"\">");
            pw.println("</applet>");
            pw.println("</body>");
            pw.println("</html>");
            pw.close();
            bw.close();
            fwrite.close();
            JOptionPane.showMessageDialog(appframe, "Build Successful");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(appframe, "Build Error");
        }
    }
}