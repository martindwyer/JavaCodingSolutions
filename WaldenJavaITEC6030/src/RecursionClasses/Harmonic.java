/*
 The nth harmonic number is defined non-recursively as: 1 +1/2 + 1/3 + 1/4 + ... + 1/n. 
Come up with a recursive definition and use it to guide you to write a method definition for a double-valued method named harmonic that accepts an int parameters n and recursively calculates and returns the nth harmonic number. 
 */
package RecursionClasses;

/**
 *
 * @author marti
 */
public class Harmonic {
        
        public double harmonic(int n) {
            if(n==0) {
                    return 0.0;
            } else if (n==1) {
                    return n;
            } else if (n==2) {
                    return 1.0/n + 1;
            } else {
                    return 1.0/n + harmonic(n-1);
            }
        }
    
}
