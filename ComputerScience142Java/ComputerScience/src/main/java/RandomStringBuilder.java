import java.util.*;

/**
 * This program builds random strings twelve characters long
 * 
 * @author Martin Dwyer 
 * @version 2017-11-07
 */
public class RandomStringBuilder
{
   public static void main(String[] args) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int numChars = LETTERS.length();
        StringBuilder buildString = new StringBuilder();
        Random rg = new Random();
        Scanner kb = new Scanner(System.in);
        while (buildString.length() < 18) { // length of the random string.
            int index = rg.nextInt(numChars);
            buildString.append(LETTERS.charAt(index));
        }
        String lastStr = buildString.toString();
        System.out.println(lastStr);
    }
}
