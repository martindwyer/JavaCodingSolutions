/**
 * @author Martin Dwyer 
 * @version 2017-09-14
 * Lab 3
 */

import java.util.Random;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DistanceBetweenPointsFormatted extends JFrame
{ // begin bracket for class
    public static void main (String [] args)
    { // begin bracket for main method
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        int x3 = 0;
        int y3 = 0;
        int length = 0;
        int leftSide = 0;
        int size = 0;
        double d1 = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        
        String format1;
        String format2;

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
        
        System.out.println("This program generates the coordinates for three points (x,y)");
        System.out.println("Each coordinate point is a randomly chosen integer between 5 and 20.");
        String input = JOptionPane.showInputDialog(null,"How many decimal points would you like to appear in distance calcuations?");
        size = Integer.parseInt(input);
        length = size + 10;
        format1 = "%" + length + "s" + "%" + length + "s" + "%" + length + "s\n";
        format2 = "%" + length + "." + size + "f%" + length + "." + size + "f%" + length + "." + size + "f";
                
        System.out.println("The three points were generated as follows;");
        System.out.printf("%18s%18s%18s\n","Point A","Point B","Point C");
        System.out.printf("%12d%6d%12d%6d%12d%6d\n",x1,y1,x2,y2,x3,y3);

        System.out.println("The distance between the points is as follows;");
        System.out.printf(format1,"A to B","B to C","C to A");
        System.out.printf(format2,d1,d2,d3);
        
    }
}// end bracket for main method