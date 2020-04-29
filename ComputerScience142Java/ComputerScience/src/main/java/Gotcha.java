/*********************************** NEW FILE ******************************/
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Gotcha
{
    public static void main (String [] args) 
    {
        Scanner kb = new Scanner(System.in);
        String input;
        System.out.print("Enter a line of input: ");
        input = kb.nextLine();  // reads line of input as a String
        int x;
        System.out.print("Enter a whole number: ");
        x = kb.nextInt();       // reads input value of integer
        System.out.println("You entered: " + input + " and " + x);
        System.out.print("Enter some more text: ");
        input = kb.nextLine();  // doesn't read anything - takes newline
                                // character from previous input as data
        System.out.println("\nGotcha!");
    }
}
