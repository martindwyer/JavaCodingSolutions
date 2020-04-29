import javax.swing.*;
import java.util.*;

public class InputExample {
    public static void main(String [] args) {
        int x;
        Random rg = new Random();
        String getInput;
        getInput = JOptionPane.showInputDialog(null, "Enter a number:");
        try	{
            x = Integer.parseInt(getInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "You are not worthy of my program - I am taking over");
            x = Math.abs(rg.nextInt());
        }
        JOptionPane.showMessageDialog(null, "You entered " + x);
        JOptionPane.showMessageDialog(null, "The square root of " + x +
            " is " + Math.sqrt(x));
    }
}

