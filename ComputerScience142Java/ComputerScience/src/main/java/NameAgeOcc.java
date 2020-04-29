/**
 * @author Martin Dwyer 
 * @version 2017-09-14
 * Lab 3
 */

import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NameAgeOcc extends JFrame
{ // begin bracket for class
    public static void main (String [] args)
    { // begin bracket for main method
        
        int age;
        String name;
        String occupation;
        
        Scanner kb = new Scanner(System.in);
        
        System.out.print("Please enter your full name: ");
        name = kb.nextLine();
        System.out.print("Please enter your age: ");
        age = Integer.parseInt(kb.nextLine());
        System.out.print("Please enter your occupation: ");
        occupation = kb.nextLine();
      
               
        System.out.printf("%-15s%-20s\n","Name:",name);
        System.out.printf("%-15s%-20s\n","Age:",age);
        System.out.printf("%-15s%-20s\n","Occupation:",occupation);
    }
}// end bracket for main method