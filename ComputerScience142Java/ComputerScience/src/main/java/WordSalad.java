/**
 * @author Martin Dwyer 
 * @version 2017-09-14
 * Lab 3
 */

import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WordSalad extends JFrame
{ // begin bracket for class
    public static void main (String [] args)
    { // begin bracket for main method
        
        int lengthName;
        String name;
        String format;
        
        Scanner kb = new Scanner(System.in);
        
        System.out.print("Please enter your full name: ");
        name = kb.nextLine();
        lengthName = name.length();
       
        format = "%" + lengthName + "s\n" + "%" + (lengthName*2) + "s\n" + 
                   "%" + (lengthName*3) + "s\n" + "%" + (lengthName*2) + "s\n" + "%" + lengthName + "s\n";
        
        System.out.printf(format,name,name,name,name,name);
        
    }
}// end bracket for main method