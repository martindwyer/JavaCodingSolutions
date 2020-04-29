import java.util.Random;    // class describing random number generator

/**
 * Fun with random numbers & Math class methods
 * 
 * @author Cate Sheller 
 * @version 8/29/2011
 */
public class NumberFun
{
    public static void main (String [] args)
    {
        Random rg = new Random();   // instantiates random number generating object
        int rint;                   // randomly-generated integer
        double rdbl;                // randomly-generated real number
    
        rint = rg.nextInt();
        System.out.println("a random integer: " + rint);
        rint = rg.nextInt(10);
        System.out.println("a random integer between 0 and 9: " + rint);
        rint = rg.nextInt(10) + 1;
        System.out.println("a random integer between 1 and 10: " + rint);
        rint = rg.nextInt(21) - 10;
        System.out.println("a randowm integer between -10 and 10: " + rint);
    
        rdbl = rg.nextDouble();
        System.out.println("a random real number: " + rdbl);
        rdbl = rdbl + Math.abs(rint);
        System.out.println ("the sum of the last number and the absolute value of " +
                            rint + " is " + rdbl);
        System.out.println ("the square root of " + rdbl + " is " + Math.sqrt(rdbl));;
        System.out.println ("the cube root of " + rdbl + " is " + Math.cbrt(rdbl));
        System.out.println ("the value " + rdbl + " raised to the power " + rint +
                            " is " + Math.pow(rdbl, rint));
   }
}
