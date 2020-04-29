import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Lab7Part2 extends JFrame {
    static Random rg = new Random();    // random # generator shared by all
    // instances of this class
    private String input;               // used to read in # of circles
    private int numCircles;             // holds # of circles

    public Lab7Part2() {
        setSize(500,500);
        setAlwaysOnTop(true);
        setTitle("Random Circles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void getInput() {
        input = JOptionPane.showInputDialog(this, "How many circles do you want to see?");
        numCircles = Integer.parseInt(input);
    }

    public static void main (String [] args) {
        Lab7Part2 win = new Lab7Part2();
        win.getInput();
        win.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        int ct = 0;                     // keeps track of circles drawn so far
        int[] x = {0,0};                   // coordinates for top left corner of each circle's bounding
        int[] y = {0,0};
        int[] c = {0,0,0};
        Random rg = new Random();
        int s = 0; // shape selector
        // rectangle - randomly generated
        // Color randColor = new Color(0,0,0);    // color of each circle; uses 3 random numbers to instantiate
        // a color - syntax is: randColor = new Color(#,#,#); where
        // each "#" is replaced by a random value between 0 and 255

        // Loop goes here: algorithm is:
        // - generate a random color & set it as the current color
        while (ct < numCircles) {
            for (int i = 0; i<3; i++) {
                c[i] = rg.nextInt(256);
            }
            Color randColor = new Color(c[0],c[1],c[2]);
            
            // - generate random values for x & y
            for (int i = 0; i< 2; i++) {
                x[i] = rg.nextInt(500);
                y[i] = rg.nextInt(500);
            }
            // - draw a circle at the x,y value in the random color
            g.setColor(randColor);

            s = rg.nextInt(4);

            if (s==0) {            
                g.fillOval(x[0],x[1],y[1],y[1]);  // fills circular area 
            } else if (s==1) {
                g.fillRect(x[0],y[0],x[1],y[1]);  // rectangle
            } else if (s==2) {
                g.fillOval(x[0],y[0],x[1],y[1]);  // ellipse
            } else {
                g.fillRect(x[0],x[1],y[1],y[1]);  // square
            }

            // - increment the counter (ct)        
            ct ++;
        }
    }
}
