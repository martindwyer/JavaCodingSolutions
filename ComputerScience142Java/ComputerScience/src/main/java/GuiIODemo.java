
/*********************************** NEW FILE ******************************/
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
public class GuiIODemo extends JApplet
{
    int size;
    public void start()
    {
        String input = JOptionPane.showInputDialog(null,
        "Enter the size of the circle:");
        size = Integer.parseInt(input);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillOval(10,10,size,size);
    }
}