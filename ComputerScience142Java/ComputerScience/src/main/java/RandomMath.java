/**
 * @author Martin Dwyer 
 * @version 2017-09-14
 * Lab 3
 */

import java.util.Random;

public class RandomMath
{ // begin bracket for class
    public static void main (String [] args)
    { // begin bracket for main method
        int x1 = 0;
        int y1 = 0;

        Random randGen = new Random();

        x1 = randGen.nextInt(51)+50;
        y1 = randGen.nextInt(31)+10;
        
             
        System.out.println("The values are "+x1+" and "+y1);
        System.out.println(" ");
        System.out.println(x1+ " to the power of "+y1+" = "+Math.pow(x1,y1));
        System.out.println("The square root of "+y1+" is "+Math.sqrt(y1));
        System.out.println("The cube root of "+x1+" is "+Math.cbrt(x1));
        System.out.println("The natural log of "+y1+" is "+Math.log(y1));
        System.out.println("The log base 10 of "+x1+" is "+Math.log10(x1));
        System.out.println("The hypotenuse of the right traingle with sides "+x1+" and "+y1+" is "+Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2)));
        
    }
}// end bracket for main method