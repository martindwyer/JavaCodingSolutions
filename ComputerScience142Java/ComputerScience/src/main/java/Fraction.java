/**
 * Fraction Lab
 * @author Martin Dwyer
 * @version 14 Nov 2017
 * 
 */

import java.util.*;

public class Fraction {
    private int num, den;

    public Fraction(int n, int d) {
        num = n;
        setDenom(d);
    }
    public Fraction () {
        num = 1;
        den = 1;
    }
    public Fraction (int n) {
        this(n, 1);
    }
    public String toString() {
        return num + "/" + den;
    }
    public void setDenom(int d) {
        if (d==0)
            throw new IllegalArgumentException
              ("Zero denominator - not allowed");
        den = d;
    }
    public void setNumer (int n) {
        num = n;
    }
    public Fraction simplify() {
        int x = num, y = den;
        num = num / gcd(x, y);
        den = den / gcd(x, y);
        return this;
    }
    public static int gcd (int a, int b) {
        while(b != 0)  {
            int r = b;
            b = a % r;
            a = r;
        }
        return a;
    }
    public double toDouble() {
        return (double)num / den;
    }      
    public Fraction plus(Fraction that) {
        Fraction sum;
        int a = this.num,
        b = this.den,
        c = that.num,
        d = that.den;
        sum = new Fraction((a*d + b*c), b*d);
        return sum;
    }
    
    public Fraction plus (int n) {
        Fraction sum = new Fraction(n);
        return sum.plus(this);
    } 
    public int compareTo (Fraction other) {
        if(this.toDouble() > other.toDouble())
            return 1;
        if(this.toDouble() < other.toDouble())
            return -1;
        return 0;
    }
        
    // Methods to be added by student; replace stub code with your own
        
    public Fraction (double equiv) { 
        num = (int)((int)(equiv*10000))/gcd(((int)(equiv*10000)),10000);
        den = (int)(10000/gcd(((int)(equiv*10000)),10000));
           
    }
        
    public Fraction minus(Fraction other){
        Fraction difference;
        int c = this.num;
        int d = this.den;
        int a = other.num;
        int b = other.den;
        difference = new Fraction((b*c-a*d),b*d);
        difference = difference.simplify();
        return difference;
    }
        
    public Fraction minus (int n) {
        Fraction difference = new Fraction(n);
        return difference.minus(this);
    }
    
    public Fraction times(Fraction other) {
        Fraction product;
        int a = this.num;
        int b = this.den;
        int c = other.num;
        int d = other.den;
        product = new Fraction(a*c,b*d);
        product = product.simplify();
        return product;
    
    }
    
    public Fraction times (int n) {
        Fraction product = new Fraction(n);
        return product.times(this);       
    }
        
    public Fraction dividedBy(Fraction other) {
        Fraction divisor;
        int c = this.num;
        int d = this.den;
        int a = other.num;
        int b = other.den;
        divisor = new Fraction(c*b,a*d);
        divisor = divisor.simplify();
        return divisor;

    }
        
    public Fraction dividedBy(int n) {
        Fraction divisor = new Fraction(n);
        return divisor.dividedBy(this);       

    }
        
    public boolean equals (Fraction other) {
        int a = this.num;
        int b = this.den;
        int c = other.num;
        int d = other.den;
        if (Math.abs(((double)a/(double)b) - ((double)c/(double)d)) < 0.0001) {
            return true;
        } else {
            return false;
        }
    }
        
    public boolean lessThan(Fraction other) {
        int a = this.num;
        int b = this.den;
        int c = other.num;
        int d = other.den;
        if ((((double)a/(double)b) - ((double)c/(double)d))  <= -0.0001) {
            return true;
        } else {
            return false;
        }
    }
        
    public boolean greaterThan(Fraction other) {
        int a = this.num;
        int b = this.den;
        int c = other.num;
        int d = other.den;
        if ((((double)a/(double)b) - ((double)c/(double)d))  >= 0.0001) {
            return true;
        } else {
            return false;
        }
    }
    
}