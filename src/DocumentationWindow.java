import javax.swing.*;
public class DocumentationWindow extends JFrame
{
    public DocumentationWindow()
    {
        setVisible(true);
        setTitle("Documentation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JScrollPane scroll = new JScrollPane();
        JTextPane pane = new JTextPane();
        pane.setEditable(false);
        try
        {
            pane.setPage(getClass().getResource("Documentation.htm"));
        }
        catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
        scroll.getViewport().add(pane);
        add(scroll);
        pack();
        setSize(550,650);
    }
}
