//Holds information for one Graphic. includes the image, width, height, name, and a copy to the original source for the purpose of saving.
import java.awt.*;
import java.io.*;
public class AppletGraphic implements Serializable
{
    public transient Image img;
    public int width;
    public int height;
    public String name;
    public File savecopy;
    public transient AppletFrame appframe;
    public AppletGraphic(Image image, int imgwidth, int imgheight, String imgname, AppletFrame af, File copy)
    {
        appframe = af;
        img = image;
        width = imgwidth;
        height = imgheight;
        name = imgname;
        savecopy = copy;
    }
    public void changeProperties(int imgwidth, int imgheight, String imgname)
    {
        width = imgwidth;
        height = imgheight;
        appframe.changeName(1, name, imgname);
        name = imgname;
    }
}
