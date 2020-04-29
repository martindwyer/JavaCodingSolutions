
import java.io.*;   // provides stream classes
import java.util.*; // for Scanner & Exception classes

/**
 * Martin Dwyer
 * Lab 06
 * 
 * @version 10/12/2017
 */

public class Lab7Part4 {
    public static void main (String [] args) {

        Scanner kb = new Scanner(System.in); // for user interaction -

        boolean keepEntering = true;
        String input = null;
        double num = 0.0;
        double sum = 0.0;
        double min = 99999999999.0;
        double max = 0.0;
        double avg = 0.0;
        int count = 0;

        while(keepEntering == true) {
            System.out.println("Enter a number or 'q' to exit");
            try {
                input = kb.nextLine();
                if(input.equalsIgnoreCase("q")) {
                    keepEntering = false;
                    break;
                }
                num = Double.parseDouble(input);
                sum += num;
                if (num <= min) {
                    min = num;
                }
                if (num >= max) {
                    max = num;
                }
                count += 1;
            }catch(NumberFormatException e) {
                System.out.println("You need to enter a NUMBER to continue.  Try again.");
            }

        }

        avg = sum / count ;
        System.out.println("");        
        System.out.println("");        
        System.out.println("");
        System.out.println("");
        System.out.println("Thanks for using our calculator!");
        System.out.println("");
        System.out.println("Here's the results calculated from your input:");
        System.out.println("");
        System.out.println("Sum of the numbers: " + sum);
        System.out.println("Minimum of the numbers: " + min);
        System.out.println("Maximum of the numbers: " + max);
        System.out.println("Average of the numbers: " + avg);

    }
}

