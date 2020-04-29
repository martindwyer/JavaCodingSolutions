
import java.util.*;
public class IOTest {
    public static void main (String [] args) {
        Scanner kb = new Scanner (System.in);
        boolean end = false;
        while (!end) {
            System.out.print("Enter some text; enter a number to quit: ");
            if (kb.hasNextDouble())
                end = true;
            else {
                String input = kb.nextLine();
                System.out.println ("You entered: " + input);
            }
        }
    }
}

