import java.util.*;

public class UtilLab3 {
    /**
     * We want to make a row of bricks that is goal inches long. 
     * We have a number of small bricks (1 inch each) and big bricks
     * (5 inches each). Return true if it is possible to make the goal
     * by choosing from the given bricks. This is a little harder than
     * it looks and can be done without any loops. 
     * Examples:
     *  makeBricks(3, 1, 8) â†’ true
     *  makeBricks(3, 1, 9) â†’ false
     *  makeBricks(3, 2, 10) â†’ true
     */
    public static boolean makeBricks(int small, int big, int goal) {
        // replace code below with your code:
        return true;
    }
    
    /**
     * Given three ints, a b c, one of them is small, one is medium 
     * and one is large. Return true if the three values are evenly 
     * spaced, so the difference between small and medium is the same 
     * as the difference between medium and large.
     * Examples:
     *  evenlySpaced(2, 4, 6) â†’ true
     *  evenlySpaced(4, 6, 2) â†’ true
     *  evenlySpaced(4, 6, 3) â†’ false
     */
    public static boolean evenlySpaced(int a, int b, int c) {
        // replace code below with your code:
        return true;
    }
    
    /**
     * We want make a package of goal kilos of chocolate. We have small
     * bars (1 kilo each) and big bars (5 kilos each). Return the number
     * of small bars to use, assuming we always use big bars before small
     * bars. Return -1 if it can't be done.
     * Examples:
     *  makeChocolate(4, 1, 9) â†’ 4
     *  makeChocolate(4, 1, 10) â†’ -1
     *  makeChocolate(4, 1, 7) â†’ 2
     */
    public static int makeChocolate(int small, int big, int goal) {
        // replace code below with your code:
        return 42;
    }
    
 


 /**
     * Given 3 int values, a b c, return their sum. However, if one 
     * of the values is the same as another of the values, it does not
     * count towards the sum.
     * Examples:
     *  loneSum(1, 2, 3) â†’ 6
     *  loneSum(3, 2, 3) â†’ 2
     *  loneSum(3, 3, 3) â†’ 0
     */
    public static int loneSum(int a, int b, int c) {
        // replace code below with your code:
        return 42;
    }
    public static void main(String [] args) {
        System.out.println("Testing, testing");
    }
}