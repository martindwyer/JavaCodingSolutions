/*
 The sum of the numbers from 1 to n can be defined recursively as follows:

    The sum from 1 to 1 is 1.
    The sum from 1 to n is n more than the sum from 1 to n-1. 

Write a int-method named sum that accepts an int parameter, n, and recursively calculates and returns the sum of the numbers from 1 to n. .


 */
package RecursionClasses;


public class Sum {

    public static void main(String[] args) {
        int s = sum(15);
        
        System.out.println(s);
    }

    public static int sum(int n) {
	if (n == 1 ) {
		return 1;
	} else {
		return n + sum(n-1);
	}
}
}
