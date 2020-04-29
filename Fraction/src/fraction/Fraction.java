/**
 * Author:      Martin Dwyer
 * Course:      ITEC 6130: Walden University
 * Assignment:  Unit 1
 * Date:        2019-03-06
 * 
 * Description: Build Fraction class and JUnit Testing class FractionTest
 *              Testing can be completed by running FractionText.java
 */
package fraction;

/**
 * Fraction class with objects defined by their attributes: numerator and denominator
 * 
 * @author  Martin Dwyer
 * @version 1.0
 */
public class Fraction {

    private int numerator;
    private int denominator;

    /**
     * Constructor to create Fraction object
     *
     * @param n integer representing numerator of Fraction object
     * @param d integer representing denominator of Fraction object
     */
    public Fraction(int n, int d) {
        try {
            int test = n/d;
        } catch (ArithmeticException e) {
            throw e;
        }
        this.denominator = d;
        this.numerator = n;
        
            
    }
        

    /**
     * Finds the sum of two fractions
     *
     * @param f Fraction object
     * @param g Fraction object
     * @return Fraction object equals f plus g in simplified form
     */
    public static Fraction add(Fraction f, Fraction g) {
        int a = f.numerator;
        int b = f.denominator;
        int c = g.numerator;
        int d = g.denominator;
        int newNumerator = a*d + b*c;
        int newDenominator = b*d;
        Fraction result = new Fraction(newNumerator,newDenominator).simplify();
        return result;
    }

    /**
     * Finds the difference of two fractions
     *
     * @param f Fraction object
     * @param g Fraction object
     * @return Fraction object equals the difference of f minus g in simplified form
     */
    public static Fraction subtract(Fraction f, Fraction g) {
        int a = f.numerator;
        int b = f.denominator;
        int c = g.numerator;
        int d = g.denominator;
        int newNumerator = a*d - b*c;
        int newDenominator = b*d;
        Fraction result = new Fraction(newNumerator,newDenominator).simplify();
        return result;
    }

    /**
     * Determines the product of two Fraction objects
     *
     * @param f Fraction object
     * @param g Fraction object
     * @return Fraction object representing the product of f and g in simplified form
     */
    public static Fraction multiply(Fraction f, Fraction g) {
        int a = f.numerator;
        int b = f.denominator;
        int c = g.numerator;
        int d = g.denominator;
        int newNumerator = a*c;
        int newDenominator = b*d;
        Fraction result = new Fraction(newNumerator,newDenominator).simplify();
        return result;
    }

    /**
     * Divide one fraction into another
     *
     * @param f Fraction object
     * @param g Fraction object
     * @return Fraction object representing a divided by b
     */
    public static Fraction divide(Fraction f, Fraction g) {
        int a = f.numerator;
        int b = f.denominator;
        int c = g.numerator;
        int d = g.denominator;
        int newNumerator = a*d;
        int newDenominator = b*c;
        Fraction result = new Fraction(newNumerator,newDenominator).simplify();
        return result;
    }

    /**
     * Determine the greatest common denominator of two Fraction objects
     *
     * @param a Fraction object
     * @param b Fraction object
     * @return integer representing the greatest common denominator of a and b
     */
    public static int gcd(int a, int b) {
        // Using Euclid's algorithm
        int r;
        while (b != 0) {
            r = b;
            b = a % r;
            a = r;
        }
        return a;
    }

    
    /**
     * Instance method. Returns the simplified form of any fraction
     * @return simplified form of Fraction object
     */
    public Fraction simplify() {
        int x = numerator, y = denominator;
        numerator = numerator / gcd(x, y);
        denominator = denominator / gcd(x, y);
        return this;
    }

    /**
     * Instance method.  Determines if Fraction instance is equal to object argument
     * 
     * @param obj a Fraction object to be tested for equality
     * @return true if equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        if (this.numerator != other.numerator) {
            return false;
        }
        if (this.denominator != other.denominator) {
            return false;
        }
        return true;
    }

    /**
     * Converts Fraction object to string text 
     * @return the object String "numerator / denominator"
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

}
