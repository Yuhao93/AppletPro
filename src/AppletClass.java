//Holds information for a Class, contains names of the instances, the code, and the name of the Class
import java.io.*;
public class AppletClass implements Serializable
{
    //each String in the array corresponds to the code for a event, the lines of code for one event is separated by "/n"
    public String[] codes;
    //each field of the class goes in the format type of field, name of field.
    public String[] instances;
    //class name
    public String classname;
    //the AppletFrame that this class belongs to. transient makes this class savable.
    public transient AppletFrame appframe;
    public AppletClass(String name, AppletFrame af)
    {
        appframe = af;
        classname = name;
        codes = new String[13];
        for (int i=0;i<codes.length;i++)
        {
            codes[i] = "";
        }
        instances = new String[0];
    }
    //whenever the name of a class is changed, this is called.
    public void changeProperties(String newname)
    {
        appframe.changeName(0, classname, newname);
        classname = newname;
    }
}