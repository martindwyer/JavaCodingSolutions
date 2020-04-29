// Starter test class for Fraction; add to this as you add methods so
// that you can test your own code. 
import java.util.*;

public class FractionTester {
    public static void main(String [] args) {
        Random rg = new Random();
        Scanner kb = new Scanner(System.in);
        boolean good;
        int x;
        do {
            Fraction f = new Fraction(rg.nextInt(4)+1, rg.nextInt(9)+1);
            Fraction g = new Fraction (rg.nextInt(4)+1, rg.nextInt(9)+1);
            System.out.println("f=" + f);
            System.out.println("g=" + g);
            Fraction h = f.plus(g);
            h.simplify();
            // Output for random testing of fractional calculators
            System.out.println("");
            System.out.println("Here are the results for randomly generated fractions.");
            System.out.println("The program added g to f; and the result is " + h);
            System.out.println("The program calculated " + g + " minus " + f + " to be " + (g.minus(f)).toString());
            System.out.println("The program calculated " + g + " times " + f + " to be " + (g.times(f)).toString());
            System.out.println("The program calculated " + g + " divided by " + f + " equals " + (g.dividedBy(f)).toString());
            System.out.println("The statment '" + g + " equals " + f + "' is obviously " + g.equals(f));
            System.out.println("The statment '" + g + " is less than " + f + "' is obviously " + g.lessThan(f));
            System.out.println("The statment '" + g + " is greater than " + f + "' is obviously " + g.greaterThan(f));
            System.out.println("");

            int n = rg.nextInt(4)+1;
            g = g.plus(n);
            Fraction nf = new Fraction(n);
            // Out for random testing of integer methods
            System.out.println("");
            System.out.println("Test results for random integers interacting with fractions.");
            System.out.println("Adding " + n + " to g; result is " + g.simplify());
            System.out.println("The program calculated " + n + " minus " + g + " to be " + (g.minus(n)).toString());
            System.out.println("The program calculated " + n + " times " + g + " to be " + (g.times(n)).toString());
            System.out.println("The program calculated " + n + " divided by " + g + " equals " + (g.dividedBy(n)).toString());
            System.out.println("The statment '" + g + " equals " + n + "' is obviously " + g.equals(n));
            System.out.println("The statment '" + g + " is less than " + n + "' is obviously " + g.lessThan(nf));
            System.out.println("The statment '" + g + " is greater than " + n + "' is obviously " + g.greaterThan(nf));
            System.out.println("");
            
            double d = new Random().nextDouble();
            double e = new Random().nextDouble();
            Fraction p = new Fraction(d);
            Fraction q = new Fraction(e);
            // Out for random testing of integer methods
            System.out.println("");
            System.out.println("Test results for random doubles converted to fractions.");
            System.out.println("The program converted " + d + " to " + p.toString());
            System.out.println("The program converted " + e + " to " + q.toString());
            System.out.println("Adding " + p + " to " + q + " the result is " + p.plus(q).simplify());
            System.out.println("The program calculated " + p + " minus " + q + " to be " + (p.minus(q)).toString());
            System.out.println("The program calculated " + p + " times " + q + " to be " + (p.times(q)).toString());
            System.out.println("The program calculated " + p + " divided by " + q + " equals " + (p.dividedBy(q)).toString());
            System.out.println("The statment '" + p + " equals " + q + "' is obviously " + p.equals(q));
            System.out.println("The statment '" + p + " is less than " + q + "' is obviously " + p.lessThan(q));
            System.out.println("The statment '" + p + " is greater than " + q + "' is obviously " + p.greaterThan(q));
            System.out.println("");            
            System.out.print("Enter a number to test, other character to quit:");
            try {
                x = kb.nextInt();
                good = true;
            }
            catch(InputMismatchException z) {
                good = false;
                kb.nextLine();
            }
        } while (good);          
    }
}