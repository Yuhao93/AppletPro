//Holds information for a method, includes code, parameters, and the name of the method
import java.io.*;
public class AppletMethod implements Serializable
{
    public String name;
    public String[] params;
    public AppletFrame appframe;
    public String code;
    public String returntype;
    public AppletMethod(String n, AppletFrame af)
    {
        name = n;
        appframe = af;
        params = new String[0];
        returntype = "void";
    }
    public void changeProperties(String n)
    {
        appframe.changeName(3, name, n);
        name = n;
    }
}
