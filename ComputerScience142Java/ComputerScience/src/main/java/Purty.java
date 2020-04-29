/**
 * Purty: draws a pretty picture with simple geometric shapes
 * 
 * @author Cate Sheller
 * @version 19 August 2015
 */

import java.awt.*;  // includes Graphics and Color classes & associated methods
import javax.swing.JFrame;   // includes JFrame class & associated methods
import java.util.Random;    // includes class for generating random integers

public class Purty extends JFrame
/*
 * The keyword "extends" is Java's way of expressing the object-oriented
 * programming concept of inheritance.  The class heading indicates not
 * only the name of the class, but also that this class inherits all the
 * characteristics (data and methods) of the JFrame class, as well as
 * any classes JFrame inherits from.
 */
{
    public static void main(String [] args)
    {
        Purty pic = new Purty();    // calls Purty class's constructor,
        // creating a new object
        pic.setVisible(true);       // displays the object window

    }
    // Constructor: a method that describes default characteristics of an object
    public Purty()
    {
        this.setSize(500, 500);
    }

    /*
     * paint() is a method inherited from JFrame; in its original form, it
     * simply draws an empty window.  We are overriding the inherited method,
     * adding our own code that draws a picture in the window.
     */
    public void paint (Graphics g)
    {
        super.paint(g); // instructs the parent class to invoke its own
        // paint method, thus ensuring that our own
        // window will draw itself correctly

        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        int x3 = 0;
        int y3 = 0;
        double d1 = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;

        Random randGen = new Random();

        x1 = randGen.nextInt(16)+5;
        y1 = randGen.nextInt(16)+5;
        x2 = randGen.nextInt(16)+5;
        y2 = randGen.nextInt(16)+5;
        x3 = randGen.nextInt(16)+5;
        y3 = randGen.nextInt(16)+5;

        g.drawLine(20*x1,20*y1,20*x2,20*y2);
        g.drawLine(x2*20,y2*20,x3*20,y3*20);
        g.drawLine(x3*20,y3*20,x1*20,y1*20);
              

        /*
        Random rg = new Random();   // instantiates a Random object, which
        // has methods that can produce random
        // numbers

        int red,      // will hold the red component of a Color object
        grn,      // will hold the green component of a Color object
        blu;      // will hold the blue component of a Color object

        Color surprise; // object reference that will refer to a random Color
        // object to be instantiated later

        g.setColor(Color.RED);  // sets initial drawing color for the graphics
        // object to the constant value RED which is
        // defined in the Color class
        g.fillOval(150,100,200,200);    // draws a circle using reference point
        // 150,100 with diameter 200
        g.setColor(Color.BLUE); // changes drawing color to blue
        g.fillOval(75,175,200,200);    // draws overlapping circle of same size
        g.setColor(Color.GREEN);    // changes drawing color to green
        g.fillOval(225,175,200,200);    // draws third overlapping circle

        // set up random values and create Color object using them:
        red = rg.nextInt(256);
        grn = rg.nextInt(256);
        blu = rg.nextInt(256);
        surprise = new Color(red, grn, blu);
        g.setColor(surprise);   // change color to the mystery hue
        g.fillOval(150,250,200,200);    // draw fourth circle
         */
    }
}