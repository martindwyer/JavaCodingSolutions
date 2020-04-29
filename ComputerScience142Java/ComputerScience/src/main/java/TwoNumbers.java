/**
 * @author Martin Dwyer 
 * @version 2017-09-14
 * Lab 3
 */

import java.util.Random;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TwoNumbers extends JFrame
{ // begin bracket for class
    public static void main (String [] args)
    { // begin bracket for main method
        int n1;
        int n2;
              
        
        String input = JOptionPane.showInputDialog(null,"Please enter a number: ");
        n1 = Integer.parseInt(input);
        String input2 = JOptionPane.showInputDialog(null,"Please enter another number: ");
        n2 = Integer.parseInt(input2);
        
        System.out.printf("The sum of the two numbers%10d\n",(n1+n2));
        System.out.printf("The product of the two numbers%10d\n",(n1*n2));
        
    }
}// end bracket for main method