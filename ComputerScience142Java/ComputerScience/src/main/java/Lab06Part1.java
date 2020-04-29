import java.io.*;   // provides stream classes
import java.util.*; // for Scanner & Exception classes

/**
 * Martin Dwyer
 * Lab 06
 * 
 * @version 10/12/2017
 */
public class Lab06Part1 {
    public static void main (String [] args) {

        Scanner kb = new Scanner(System.in); // for user interaction -

        boolean validTemp = false;
        double fTemp = 0.0;
        double wSpeed = 0.0;
        double cTemp = 0.0;
        double wChill = 0.0;

        System.out.println("Enter a temperature less than 50 degrees Fahrenheit below:");
        while(validTemp != true) {
            try {
                fTemp = kb.nextDouble();
                if (fTemp > 50.0) {
                    throw new IllegalArgumentException();
                }
                else {
                    validTemp = true;
                }
            } // end of try
            catch(InputMismatchException e) {
                System.out.println("You need to enter a NUMBER less than 50.");
                kb.next();
            }
            catch(IllegalArgumentException e) {
                System.out.println("Your input is not a number less than 50.  Try again.");

            } // end of catch
        }
        System.out.println("Now enter wind speed below:");
        wSpeed = kb.nextDouble();

        cTemp = (5.0/9.0)*(fTemp - 32);
        wChill = 35.74 + (0.6215*fTemp) - (35.75*(Math.pow(wSpeed,0.16))) + 0.4275*fTemp*(Math.pow(wSpeed,0.16));

        System.out.printf("%20s%20s%20s%20s\n","Degrees F","Degrees C","Wind Speed","Wind Chill");
        System.out.printf("%20.2f%20.2f%20.2f%20.2f",fTemp,cTemp,wSpeed,wChill);

    }
}

