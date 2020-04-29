import java.util.Scanner;

/**
 * A silly example to illustrate String method calls
 * 
 * @author Cate Sheller 
 * @version 8/29/2011
 */
public class NameGame
{
   public static void main (String [] args)
   {
       String   name,   // user name - to be read in
                frag;   // fragment of user name - to be calculated
                
       final String S1 = new String ("Bo-b"); // nonsense phrase for use in game
       final String S2 = new String ("Banana fana fo-f"); // another nonsense phrase
       final String S3 = new String ("Fe fi mo-m"); // final nonsense phrase
       
       final char SP = ' '; // space between words & phrases
       
       Scanner kb = new Scanner(System.in); // object to represent keyboard for input
       
       System.out.print("What is your first name? ");
       name = kb.next();    // reads input up to first delimiting character
       frag = name.substring(1, name.length()); // all but the first letter of name
       
       // Exciting & festive output:
       System.out.println(name + SP + name + SP + S1 + frag);
       System.out.println(S2 + frag);
       System.out.println(S3 + frag + SP + name);
    }
       
                
       
}
