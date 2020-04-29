/**
 * Making Change
 * @author Martin Dwyer
 * @version 20 Sep 2017
 * 
 * A program in Java which directs the cashier to give correct change to a 
 * customer.  The program has two inputs; (1) the total sale and (2) the amount 
 * collected from the customer.  The program computes the difference and then 
 * displays the change in its appropriate denominations (dollars, quarters, 
 * dimes, nickels, and pennies).  
 * 
 * It is assumed that; (1) the total sale is always greater than the amount 
 * collected, and (2) the cashier always properly inputs the sale and collection
 * amounts (there is no input validation). 
 * 
 */

import java.util.Scanner; // bring in code to facilitate keyboard input

public class MakeChange {
    public static void main (String [] args) {

        // Setting up new Scanner object (kb) with constructor Scanner()
        Scanner kb = new Scanner(System.in);

        // Setting up constants to be used for conversion factors
        final int pConvert = 100; // Constant for converting dollars to pennies
        final int qFactor = 25;   // Constant for converting pennies to quarters
        final int dFactor = 10;   // Constant for converting pennies to dimes
        final int nFactor = 5;    // Constant for converting pennies to nickels
        final int pFactor = 1;    // Constant for pennies

        // variable doubles will be declared and initiated for input
        double amountCharged = 0.0;     // Total of the sale to the customer
        double amountCollected = 0.0;   // Amount of money collected

        // variable ints declared and initiated for completion of the program
        int amountChange = 0;      // Amount of change in pennies (non-reducing)
        int remainingToChange = 0; // Change as allocated in pennies (reducing)
        int numDollars = 0;        // Number of dollars in change
        int numQuarters = 0;       // Number of dollars in change
        int numDimes = 0;          // Number of dollars in change
        int numNickels = 0;        // Number of dollars in change
        int numPennies = 0;        // Number of dollars in change

        // Read in the amount to be changed from the keyboard
        System.out.println("How much was the total sale? ");  
        amountCharged = kb.nextDouble();              // Reads in total sale
        System.out.println("How much did the customer pay? ");  
        amountCollected = kb.nextDouble();           // Reads in total collected

        // Calculate the amount to change in pennies (a integer)
        amountChange = (int)(amountCollected*pConvert)-(int)(amountCharged*pConvert);  

        // In order to avoid rounding errors, and to simplify the calculations, 
	// the amount to be changed will be converted to pennies (int).  
        remainingToChange = amountChange;   // Getting change ready to give out.

        // Calculate change largest denomination to smallest, using integer 
	// division for calculating dollars, Deducting dollars from remaining 
	// change.  Continuing to reduce remaining change until depleted.
	numDollars = (remainingToChange/pConvert);   
        remainingToChange -= (numDollars*pConvert);  
        numQuarters = (remainingToChange/qFactor);   
        remainingToChange -= (numQuarters*qFactor);  
        numDimes = (remainingToChange/dFactor);     
        remainingToChange -= (numDimes*dFactor);
        numNickels = (remainingToChange/nFactor);
        remainingToChange -= (numNickels*nFactor);
        numPennies = (remainingToChange/pFactor);

        // display results
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Total Sale:  $" + amountCharged);
        System.out.println("Total Collected:  $" + amountCollected);
        System.out.println("Change is:  $" + ((double)amountChange/pConvert));
        System.out.println(" ");
        System.out.println("That is "+numDollars+" dollars, "+numQuarters+
			" quarters, "+numDimes+" dimes,"+numNickels+" nickels,"
			+numPennies+" penny(s).");
        System.out.println(" ");
        System.out.println("Thank you for making change with me!");

    } // end of main method
} // end of class