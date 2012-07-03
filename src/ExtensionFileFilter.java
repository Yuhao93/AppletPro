//A class which extends FileFilter to specify which types of graphics and audios can be used
//Source Code copyright 2004-2006 Riad Djemili http://www.java2s.com/Code/Java/Swing-JFC/ExtensionFileFilter.htm
import java.io.*;

import javax.swing.filechooser.FileFilter;

/**
 * A sime file filter for file choosers.
 *
 * @author djemili
 */
public class ExtensionFileFilter extends FileFilter implements Serializable
{
    private String m_extension;
    private String m_description;

    public ExtensionFileFilter(String extension, String description)
    {
        m_extension = extension;
        m_description = description;
    }
    public boolean accept(File f)
    {
        return f.isDirectory() || f.getName().endsWith(m_extension);
    }
    public String getDescription()
    {
        return m_description;
    }

    public String getExtension()
    {
        return m_extension;
    }
}
