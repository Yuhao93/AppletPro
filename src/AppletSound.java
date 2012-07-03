//Holds the information for one Audio, contains the name, the AudioClip, and a copy referring back to the original source for saving purposes
import java.applet.*;
import java.io.*;
public class AppletSound implements Serializable
{
	public transient AudioClip sound;
	public String name;
	public String filename;
	public File savecopy;
	public transient AppletFrame appframe;
	public AppletSound(AudioClip ac, String title, String soundfilename, AppletFrame af, File copy)
	{
		appframe = af;
		name = title;
		sound = ac;
		filename = soundfilename;
		savecopy = copy;
	}
	public void changeProperties(String title)
	{
		appframe.changeName(2, name, title);
		name = title;
	}
}