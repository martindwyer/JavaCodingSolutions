/**
 * @author Martin Dwyer 
 * @version 2017-09-14
 * Lab 3
 */

import java.util.Random;
import java.awt.*;
import javax.swing.JFrame;

public class DistanceBetweenPoints extends JFrame
{ // begin bracket for class
    public static void main (String [] args)
    { // begin bracket for main method
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

        d1 = Math.sqrt((Math.pow(x2-x1,2)+Math.pow(y2-y1,2)));
        d2 = Math.sqrt((Math.pow(x3-x2,2)+Math.pow(y3-y2,2)));
        d3 = Math.sqrt((Math.pow(x1-x3,2)+Math.pow(y1-y3,2)));

        System.out.println("The three points generated were;");
        System.out.println("First point  ("+x1+","+y1+")");
        System.out.println("Second point  ("+x2+","+y2+")");       
        System.out.println("Third point  ("+x3+","+y3+")");

        System.out.println("The distance between the points is as follows;");
        System.out.println("Distance between points one and two: "+d1);
        System.out.println("Distance between points two and three: "+d2);
        System.out.println("Distance between points three and one: "+d3);
        
    }
}// end bracket for main method